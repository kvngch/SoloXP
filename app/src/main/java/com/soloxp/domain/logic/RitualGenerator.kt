package com.soloxp.domain.logic

import com.soloxp.domain.model.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

data class DailyRitual(
    val quest: Quest,
    val availableAt: Long,
    val expiresAt: Long,
    val isCompleted: Boolean,
    val firstClearBonusActive: Boolean
)

object RitualGenerator {
    
    private val categoryRotation = listOf(
        QuestCategory.MIND,      // Monday
        QuestCategory.SPORT,     // Tuesday
        QuestCategory.HEALTH,    // Wednesday
        QuestCategory.SOCIAL,    // Thursday
        QuestCategory.DISCIPLINE,// Friday
        QuestCategory.SLEEP,     // Saturday
        QuestCategory.MIND       // Sunday
    )
    
    /**
     * Generates the daily ritual for a given date
     * @return DailyRitual with BOSS quest and timing info
     */
    fun generateDailyRitual(
        date: LocalDate = LocalDate.now(),
        lastCompletedDate: Long = 0,
        currentTime: Long = System.currentTimeMillis()
    ): DailyRitual {
        val dayOfWeek = date.dayOfWeek.value - 1 // 0 = Monday
        val category = categoryRotation[dayOfWeek % categoryRotation.size]
        
        // Calculate midnight timestamps
        val midnightToday = date.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
        val midnightTomorrow = date.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
        val noonToday = date.atTime(12, 0).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
        
        // Check if completed today
        val isCompleted = lastCompletedDate >= midnightToday
        
        // First clear bonus active if current time is before noon
        val firstClearActive = currentTime < noonToday && !isCompleted
        
        val quest = Quest(
            id = "ritual_${date}",
            title = "Rituel du ${getDayName(dayOfWeek)}: ${getCategoryTitle(category)}",
            category = category,
            difficulty = Difficulty.BOSS,
            durationMinutes = 45,
            xpReward = if (firstClearActive) 400 else 200, // Double XP before noon
            instructions = getRitualInstructions(category),
            successCriteria = "Rituel accompli avec dévotion",
            isCompleted = isCompleted
        )
        
        return DailyRitual(
            quest = quest,
            availableAt = midnightToday,
            expiresAt = midnightTomorrow,
            isCompleted = isCompleted,
            firstClearBonusActive = firstClearActive
        )
    }
    
    private fun getDayName(dayIndex: Int): String {
        return when (dayIndex) {
            0 -> "Lundi"
            1 -> "Mardi"
            2 -> "Mercredi"
            3 -> "Jeudi"
            4 -> "Vendredi"
            5 -> "Samedi"
            6 -> "Dimanche"
            else -> "Jour"
        }
    }
    
    private fun getCategoryTitle(category: QuestCategory): String {
        return when (category) {
            QuestCategory.MIND -> "Éveil Mental"
            QuestCategory.SPORT -> "Forge Physique"
            QuestCategory.HEALTH -> "Temple Sacré"
            QuestCategory.SOCIAL -> "Lien des Âmes"
            QuestCategory.DISCIPLINE -> "Voie du Maître"
            QuestCategory.SLEEP -> "Repos du Guerrier"
        }
    }
    
    private fun getRitualInstructions(category: QuestCategory): String {
        return when (category) {
            QuestCategory.MIND -> "Médite pendant 30 minutes, puis écris tes réflexions les plus profondes."
            QuestCategory.SPORT -> "Session d'entraînement complète : cardio, force et mobilité."
            QuestCategory.HEALTH -> "Prépare 3 repas sains, prends une douche froide, hydrate-toi."
            QuestCategory.SOCIAL -> "Appelle un proche, organise une sortie, crée du lien authentique."
            QuestCategory.DISCIPLINE -> "Accomplis ta tâche la plus difficile sans distraction."
            QuestCategory.SLEEP -> "Couche-toi avant 22h, 8h de sommeil minimum, réveil sans alarme."
        }
    }
    
    /**
     * Calculates time remaining until ritual expires
     * @return Milliseconds until expiration
     */
    fun getTimeUntilExpiration(ritual: DailyRitual, currentTime: Long = System.currentTimeMillis()): Long {
        return (ritual.expiresAt - currentTime).coerceAtLeast(0)
    }
}
