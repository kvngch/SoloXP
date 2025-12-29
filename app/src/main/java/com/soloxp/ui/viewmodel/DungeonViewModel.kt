package com.soloxp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soloxp.data.local.SeedData
import com.soloxp.domain.model.Difficulty
import com.soloxp.domain.model.Quest
import com.soloxp.domain.model.Rank
import com.soloxp.domain.model.UserProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class DungeonUiState(
    val userProfile: UserProfile = UserProfile(),
    val dailyQuests: List<Quest> = emptyList(),
    val isLoading: Boolean = false,
    val xpToNextLevel: Int = 1000
)

class DungeonViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DungeonUiState())
    val uiState: StateFlow<DungeonUiState> = _uiState.asStateFlow()

    init {
        loadDungeon()
    }

    private fun loadDungeon() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            // In a real app, we'd fetch from repository
            val profile = UserProfile(rank = Rank.E, xpTotal = 450, energyLevel = 7)
            val allQuests = SeedData.getInitialQuests()
            
            val filteredQuests = filterQuestsByEnergy(allQuests, profile.energyLevel)
            
            _uiState.value = _uiState.value.copy(
                userProfile = profile,
                dailyQuests = filteredQuests.take(3),
                isLoading = false,
                xpToNextLevel = calculateXpThreshold(profile.rank)
            )
        }
    }

    fun completeQuest(quest: Quest) {
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

        _uiState.value = _uiState.value.copy(
            userProfile = updatedProfile,
            dailyQuests = _uiState.value.dailyQuests.map { 
                if (it.id == quest.id) it.copy(isCompleted = true) else it 
            },
            xpToNextLevel = calculateXpThreshold(newRank)
        )
    }

    private fun filterQuestsByEnergy(quests: List<Quest>, energy: Int): List<Quest> {
        return when {
            energy <= 3 -> quests.filter { it.difficulty == Difficulty.MICRO || it.difficulty == Difficulty.MINI }
            energy <= 7 -> quests.filter { it.difficulty != Difficulty.BOSS }
            else -> quests
        }
    }

    private fun calculateXpThreshold(rank: Rank): Int {
        return (rank.ordinal + 1) * 1000
    }
}
