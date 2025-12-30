package com.soloxp.domain.model

enum class Rank { E, D, C, B, A, S }
enum class Difficulty { MICRO, MINI, STANDARD, BOSS }
enum class QuestCategory { HEALTH, SPORT, SLEEP, SOCIAL, MIND, DISCIPLINE }
enum class Tone { CALM, EPIC }

enum class Title(val label: String, val requiredRank: Rank) {
    NEOPHYTE("Recrue", Rank.E),
    ECLAIREUR("Éclaireur", Rank.D),
    GARDIEN("Gardien", Rank.C),
    CHEVALIER("Chevalier", Rank.B),
    SEIGNEUR("Seigneur", Rank.A),
    MONARQUE("Monarque", Rank.S)
}

enum class Skill(val id: String, val label: String, val description: String, val cost: Int) {
    VITALITY_BOOST("sit_vitality", "Vitalité Accrue", "+1 Énergie Max", 1),
    XP_HUNTER("sit_xp", "Chasseur d'XP", "+5% XP par quête", 2),
    BARGAINER("sit_gold", "Négociateur", "Boutique -10% (Futur)", 1),
    TIME_WARP("sit_time", "Maître du Temps", "Quêtes -5 min", 3)
}

enum class Rarity { COMMON, RARE, LEGENDARY }
enum class ItemType { CONSUMABLE, ARTIFACT }

data class Item(
    val id: String,
    val name: String,
    val description: String,
    val rarity: Rarity,
    val type: ItemType,
    val icon: String, // Resource name or emoji
    val quantity: Int = 1,
    val addedAt: Long = System.currentTimeMillis()
)

data class UserProfile(
    val id: String = "local_user",
    val tone: Tone = Tone.EPIC,
    val energyLevel: Int = 5,
    val xpTotal: Long = 0,
    val rank: Rank = Rank.E,
    val fireCharges: Int = 3,
    val preferredTimePerDay: Int = 15, // minutes
    // Phase 10: Awakening (Deferred)
    val activeTitle: Title = Title.NEOPHYTE,
    val unlockedTitles: List<Title> = listOf(Title.NEOPHYTE),
    val skillPoints: Int = 0,
    val unlockedSkills: List<Skill> = emptyList(),
    // Phase 11: Streaks & Daily Ritual
    val currentStreak: Int = 0,
    val longestStreak: Int = 0,
    val lastQuestCompletedDate: Long = 0,
    val streakSaverUsed: Boolean = false,
    val dailyRitualCompletedDate: Long = 0
)

data class Quest(
    val id: String,
    val title: String,
    val category: QuestCategory,
    val difficulty: Difficulty,
    val durationMinutes: Int,
    val xpReward: Int,
    val instructions: String,
    val successCriteria: String,
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
