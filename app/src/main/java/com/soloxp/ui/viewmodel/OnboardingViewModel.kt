package com.soloxp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soloxp.data.repository.SoloXpRepository
import com.soloxp.domain.model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class OnboardingUiState(
    val currentStep: Int = 0,
    val energyLevel: Int = 5,
    val selectedGoals: Set<QuestCategory> = emptySet(),
    val availableTimeMinutes: Int = 30,
    val preferredTone: Tone = Tone.EPIC,
    val isComplete: Boolean = false
)

class OnboardingViewModel(private val repository: SoloXpRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()

    fun updateEnergyLevel(level: Int) {
        _uiState.value = _uiState.value.copy(energyLevel = level)
    }

    fun toggleGoal(category: QuestCategory) {
        val current = _uiState.value.selectedGoals
        val updated = if (current.contains(category)) {
            current - category
        } else {
            current + category
        }
        _uiState.value = _uiState.value.copy(selectedGoals = updated)
    }

    fun updateAvailableTime(minutes: Int) {
        _uiState.value = _uiState.value.copy(availableTimeMinutes = minutes)
    }

    fun completeOnboarding(onFinish: () -> Unit) {
        viewModelScope.launch {
            val state = _uiState.value
            val profile = UserProfile(
                energyLevel = state.energyLevel,
                preferredTimePerDay = state.availableTimeMinutes,
                tone = state.preferredTone,
                rank = Rank.E,
                xpTotal = 0,
                fireCharges = 3
            )
            repository.saveUserProfile(profile)
            _uiState.value = state.copy(isComplete = true)
            onFinish()
        }
    }

    fun nextStep() {
        _uiState.value = _uiState.value.copy(currentStep = _uiState.value.currentStep + 1)
    }

    fun previousStep() {
        if (_uiState.value.currentStep > 0) {
            _uiState.value = _uiState.value.copy(currentStep = _uiState.value.currentStep - 1)
        }
    }
}
