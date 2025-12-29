package com.soloxp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soloxp.domain.model.Rank
import com.soloxp.domain.model.QuestCategory
import com.soloxp.domain.model.Tone
import com.soloxp.domain.model.UserProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class OnboardingUiState(
    val energyLevel: Int = 5,
    val selectedGoals: Set<QuestCategory> = emptySet(),
    val availableTimeMinutes: Int = 15,
    val rank: Rank = Rank.E,
    val preferredTone: Tone = Tone.EPIC
)

class OnboardingViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()

    fun updateEnergyLevel(level: Int) {
        _uiState.value = _uiState.value.copy(energyLevel = level)
    }

    fun toggleGoal(category: QuestCategory) {
        val currentGoals = _uiState.value.selectedGoals
        val newGoals = if (currentGoals.contains(category)) {
            currentGoals - category
        } else {
            currentGoals + category
        }
        _uiState.value = _uiState.value.copy(selectedGoals = newGoals)
    }

    fun updateAvailableTime(minutes: Int) {
        _uiState.value = _uiState.value.copy(availableTimeMinutes = minutes)
    }

    fun completeOnboarding(onComplete: (UserProfile) -> Unit) {
        val finalProfile = UserProfile(
            energyLevel = _uiState.value.energyLevel,
            tone = _uiState.value.preferredTone,
            preferredTimePerDay = _uiState.value.availableTimeMinutes,
            rank = _uiState.value.rank
        )
        // Here we would normally save to repository
        onComplete(finalProfile)
    }
}
