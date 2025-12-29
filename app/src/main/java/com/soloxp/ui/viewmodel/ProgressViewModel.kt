package com.soloxp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soloxp.data.repository.SoloXpRepository
import com.soloxp.domain.model.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class ProgressUiState(
    val userProfile: UserProfile = UserProfile(),
    val totalXp: Long = 0,
    val xpToNextLevel: Long = 1000,
    val currentRank: Rank = Rank.E,
    val artifactResonance: Float = 0f, // Percentage bonus (e.g. 0.12 for 12%)
    val isLoading: Boolean = false
)

class ProgressViewModel(private val repository: SoloXpRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(ProgressUiState())
    val uiState: StateFlow<ProgressUiState> = _uiState.asStateFlow()

    init {
        observeData()
    }

    private fun observeData() {
        viewModelScope.launch {
            combine(
                repository.getUserProfile(),
                repository.getItems()
            ) { profile, items ->
                val user = profile ?: UserProfile()
                val xpThreshold = calculateXpThreshold(user.rank)
                val resonance = calculateResonance(items)
                
                ProgressUiState(
                    userProfile = user,
                    totalXp = user.xpTotal,
                    xpToNextLevel = xpThreshold.toLong(),
                    currentRank = user.rank,
                    artifactResonance = resonance,
                    isLoading = false
                )
            }.collect { state ->
                _uiState.value = state
            }
        }
    }
    
    private fun calculateResonance(items: List<Item>): Float {
        var bonus = 0f
        items.forEach { item ->
            when (item.name) {
                "Fragment de Lumière" -> bonus += 0.01f * item.quantity // 1% per item
                "Relique de l'Immortel" -> bonus += 0.10f * item.quantity // 10% per item
            }
        }
        return bonus
    }

    private fun calculateXpThreshold(rank: Rank): Int {
        return (rank.ordinal + 1) * 1000
    }
}
