package com.soloxp.domain.model

enum class Rank { E, D, C, B, A, S }
enum class Difficulty { MICRO, MINI, STANDARD, BOSS }
enum class QuestCategory { HEALTH, SPORT, SLEEP, SOCIAL, MIND, DISCIPLINE }
enum class Tone { CALM, EPIC }

data class UserProfile(
    val id: String = "local_user",
    val tone: Tone = Tone.EPIC,
    val energyLevel: Int = 5,
    val xpTotal: Long = 0,
    val rank: Rank = Rank.E,
    val fireCharges: Int = 3,
    val preferredTimePerDay: Int = 15 // minutes
)

data class Quest(
    val id: String,
    val title: String,
    val category: QuestCategory,
    val difficulty: Difficulty,
    val durationMinutes: Int,
    val xpReward: Int,
    val instructions: String,
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
