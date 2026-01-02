package com.soloxp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soloxp.data.local.SeedData
import com.soloxp.data.repository.SoloXpRepository
import com.soloxp.domain.model.Quest
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class QuestsUiState(
    val quests: List<Quest> = emptyList(),
    val isLoading: Boolean = false
)

class QuestsViewModel(private val repository: SoloXpRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(QuestsUiState())
    val uiState: StateFlow<QuestsUiState> = _uiState.asStateFlow()

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

            repository.getQuests().collect { allQuests ->
                _uiState.value = QuestsUiState(
                    quests = allQuests,
                    isLoading = false
                )
            }
        }
    }
}

