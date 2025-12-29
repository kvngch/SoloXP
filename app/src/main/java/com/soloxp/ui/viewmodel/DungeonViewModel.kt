package com.soloxp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soloxp.data.local.SeedData
import com.soloxp.data.repository.SoloXpRepository
import com.soloxp.domain.model.*
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
            val newXp = currentProfile.xpTotal + quest.xpReward
            
            var newRank = currentProfile.rank
            val threshold = _uiState.value.xpToNextLevel
            
            if (newXp >= threshold) {
                newRank = Rank.values().getOrElse(newRank.ordinal + 1) { newRank }
            }

            val updatedProfile = currentProfile.copy(
                xpTotal = newXp,
                rank = newRank
            )

            repository.saveUserProfile(updatedProfile)
            repository.updateQuest(quest.copy(isCompleted = true))
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
