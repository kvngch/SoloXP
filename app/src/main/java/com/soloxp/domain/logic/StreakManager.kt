package com.soloxp.domain.logic

import com.soloxp.domain.model.UserProfile
import java.util.concurrent.TimeUnit

enum class StreakStatus {
    ACTIVE,           // Completed quest today or yesterday
    BROKEN,           // More than 48h since last quest
    GRACE_PERIOD      // 24-48h, can use Streak Saver
}

object StreakManager {
    
    /**
     * Validates the current streak status based on last quest completion
     * @return StreakStatus indicating if streak is active, broken, or in grace period
     */
    fun validateStreak(lastQuestCompletedDate: Long, currentTime: Long = System.currentTimeMillis()): StreakStatus {
        if (lastQuestCompletedDate == 0L) return StreakStatus.BROKEN
        
        val hoursSinceLastQuest = TimeUnit.MILLISECONDS.toHours(currentTime - lastQuestCompletedDate)
        
        return when {
            hoursSinceLastQuest < 48 -> StreakStatus.ACTIVE
            hoursSinceLastQuest < 72 -> StreakStatus.GRACE_PERIOD  // 24h grace window
            else -> StreakStatus.BROKEN
        }
    }
    
    /**
     * Calculates XP bonus multiplier based on current streak
     * @return Float multiplier (0.02 per day, capped at 0.50 for 25+ days)
     */
    fun calculateStreakBonus(currentStreak: Int): Float {
        return (currentStreak * 0.02f).coerceAtMost(0.50f)
    }
    
    /**
     * Updates streak after quest completion
     * @return Updated UserProfile with new streak values
     */
    fun updateStreakOnQuestComplete(
        profile: UserProfile,
        currentTime: Long = System.currentTimeMillis()
    ): UserProfile {
        val status = validateStreak(profile.lastQuestCompletedDate, currentTime)
        
        val newStreak = when (status) {
            StreakStatus.ACTIVE -> {
                // Check if it's a new day (more than 12h since last quest)
                val hoursSinceLast = TimeUnit.MILLISECONDS.toHours(currentTime - profile.lastQuestCompletedDate)
                if (hoursSinceLast >= 12) profile.currentStreak + 1 else profile.currentStreak
            }
            StreakStatus.GRACE_PERIOD -> {
                // Streak continues if saver was used
                if (profile.streakSaverUsed) profile.currentStreak + 1 else 1
            }
            StreakStatus.BROKEN -> 1 // Reset to 1
        }
        
        val newLongest = maxOf(newStreak, profile.longestStreak)
        
        return profile.copy(
            currentStreak = newStreak,
            longestStreak = newLongest,
            lastQuestCompletedDate = currentTime,
            streakSaverUsed = false // Reset saver flag
        )
    }
    
    /**
     * Uses a Fire Charge to save a streak in grace period
     * @return Updated UserProfile or null if cannot save
     */
    fun useStreakSaver(profile: UserProfile, currentTime: Long = System.currentTimeMillis()): UserProfile? {
        val status = validateStreak(profile.lastQuestCompletedDate, currentTime)
        
        if (status != StreakStatus.GRACE_PERIOD || profile.fireCharges < 1) {
            return null // Cannot save
        }
        
        return profile.copy(
            fireCharges = profile.fireCharges - 1,
            streakSaverUsed = true
        )
    }
}
