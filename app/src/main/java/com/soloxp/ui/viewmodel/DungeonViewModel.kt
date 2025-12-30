package com.soloxp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soloxp.data.local.SeedData
import com.soloxp.data.repository.SoloXpRepository
import com.soloxp.domain.model.*
import com.soloxp.domain.logic.StreakManager
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class DungeonUiState(
    val userProfile: UserProfile = UserProfile(),
    val dailyQuests: List<Quest> = emptyList(),
    val isLoading: Boolean = false,
    val xpToNextLevel: Int = 1000
)

class DungeonViewModel(private val repository: SoloXpRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(DungeonUiState())
    val uiState: StateFlow<DungeonUiState> = _uiState.asStateFlow()

    init {
        observeData()
    }

    private fun observeData() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            // Initial seed if empty
            repository.getQuests().first().let { quests ->
                if (quests.isEmpty()) {
                    SeedData.getInitialQuests().forEach { repository.addQuest(it) }
                }
            }

            combine(
                repository.getUserProfile(),
                repository.getQuests()
            ) { profile, allQuests ->
                val userProfile = profile ?: UserProfile()
                val filtered = filterQuestsByEnergy(allQuests, userProfile.energyLevel)
                
                DungeonUiState(
                    userProfile = userProfile,
                    dailyQuests = filtered.take(3),
                    isLoading = false,
                    xpToNextLevel = calculateXpThreshold(userProfile.rank)
                )
            }.collect { state ->
                _uiState.value = state
            }
        }
    }

    fun completeQuest(quest: Quest) {
        viewModelScope.launch {
            val currentProfile = _uiState.value.userProfile
            
            // Apply streak bonus
            val streakBonus = StreakManager.calculateStreakBonus(currentProfile.currentStreak)
            val artifactBonus = calculateArtifactBonus(quest.xpReward)
            val totalXp = (artifactBonus * (1 + streakBonus)).toInt()
            val newXp = currentProfile.xpTotal + totalXp
            
            var newRank = currentProfile.rank
            val threshold = _uiState.value.xpToNextLevel
            
            if (newXp >= threshold) {
                newRank = Rank.values().getOrElse(newRank.ordinal + 1) { newRank }
            }

            val updatedProfile = currentProfile.copy(
                xpTotal = newXp,
                rank = newRank
            )

            // Update streak
            val profileWithStreak = StreakManager.updateStreakOnQuestComplete(updatedProfile)
            
            repository.saveUserProfile(profileWithStreak)
            repository.updateQuest(quest.copy(isCompleted = true))

            // Generate loot
            com.soloxp.ui.viewmodel.util.LootGenerator.generateLoot(quest.difficulty)?.let { loot ->
                repository.saveItem(loot)
            }
        }
    }

    private suspend fun calculateArtifactBonus(baseXp: Int): Int {
        val items = repository.getItems().first()
        var bonusMultiplier = 0f
        items.forEach { item ->
            when (item.name) {
                "Fragment de Lumière" -> bonusMultiplier += 0.01f * item.quantity
                "Relique de l'Immortel" -> bonusMultiplier += 0.10f * item.quantity
            }
        }
        return (baseXp * (1 + bonusMultiplier)).toInt()
    }

    fun rerollQuests() {
        viewModelScope.launch {
            val profile = _uiState.value.userProfile
            if (profile.fireCharges > 0) {
                // Reduced charges
                val updatedProfile = profile.copy(fireCharges = profile.fireCharges - 1)
                repository.saveUserProfile(updatedProfile)
                
                // Fetch all quests to shuffle
                val allQuests = repository.getQuests().first()
                val filtered = filterQuestsByEnergy(allQuests, updatedProfile.energyLevel)
                
                // Update state with new selection
                _uiState.value = _uiState.value.copy(
                    userProfile = updatedProfile,
                    dailyQuests = filtered.shuffled().take(3)
                )
            }
        }
    }

    private fun filterQuestsByEnergy(quests: List<Quest>, energy: Int): List<Quest> {
        val available = quests.filter { !it.isCompleted }
        return when {
            energy <= 3 -> available.filter { it.difficulty == Difficulty.MICRO || it.difficulty == Difficulty.MINI }
            energy <= 7 -> available.filter { it.difficulty != Difficulty.BOSS }
            else -> available
        }
    }

    private fun calculateXpThreshold(rank: Rank): Int {
        return (rank.ordinal + 1) * 1000
    }
}
