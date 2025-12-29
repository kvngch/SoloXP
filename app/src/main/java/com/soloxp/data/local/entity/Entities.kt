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
    val preferredTimePerDay: Int
)
