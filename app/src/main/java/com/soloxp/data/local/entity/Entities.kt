package com.soloxp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.soloxp.domain.model.Difficulty
import com.soloxp.domain.model.QuestCategory

@Entity(tableName = "quests")
data class QuestEntity(
    @PrimaryKey val id: String,
    val title: String,
    val category: String, // String representation of QuestCategory
    val difficulty: String, // String representation of Difficulty
    val durationMinutes: Int,
    val xpReward: Int,
    val instructions: String,
    val successCriteria: String,
    val isCompleted: Boolean,
    val createdAt: Long
)

@Entity(tableName = "user_profile")
data class UserProfileEntity(
    @PrimaryKey val id: String = "local_user",
    val tone: String,
    val energyLevel: Int,
    val xpTotal: Long,
    val rank: String,
    val fireCharges: Int,
    val preferredTimePerDay: Int,
    val activeTitle: String,
    val unlockedTitles: String, // Comma separated
    val skillPoints: Int,
    val unlockedSkills: String, // Comma separated
    val currentStreak: Int,
    val longestStreak: Int,
    val lastQuestCompletedDate: Long,
    val streakSaverUsed: Int, // Boolean as Int (0/1)
    val dailyRitualCompletedDate: Long
)

@Entity(tableName = "items")
data class ItemEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val rarity: String,
    val type: String,
    val icon: String,
    val quantity: Int,
    val addedAt: Long
)
