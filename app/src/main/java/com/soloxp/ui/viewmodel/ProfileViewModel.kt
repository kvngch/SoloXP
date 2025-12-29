package com.soloxp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soloxp.data.repository.SoloXpRepository
import com.soloxp.domain.model.QuestCategory
import com.soloxp.domain.model.UserProfile
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class ProfileUiState(
    val userProfile: UserProfile = UserProfile(),
    val totalQuestsCompleted: Int = 0,
    val categoryStats: Map<QuestCategory, Int> = emptyMap(),
    val isLoading: Boolean = false
)

class ProfileViewModel(private val repository: SoloXpRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        loadStats()
    }

    private fun loadStats() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            combine(
                repository.getUserProfile(),
                repository.getQuests()
            ) { profile, quests ->
                val completed = quests.filter { it.isCompleted }
                val stats = completed.groupBy { it.category }.mapValues { it.value.size }
                
                ProfileUiState(
                    userProfile = profile ?: UserProfile(),
                    totalQuestsCompleted = completed.size,
                    categoryStats = stats,
                    isLoading = false
                )
            }.collect { state ->
                _uiState.value = state
            }
        }
    }
}
