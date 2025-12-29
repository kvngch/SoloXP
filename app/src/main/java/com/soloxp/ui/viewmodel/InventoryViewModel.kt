package com.soloxp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soloxp.data.repository.SoloXpRepository
import com.soloxp.domain.model.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class InventoryUiState(
    val items: List<Item> = emptyList(),
    val isLoading: Boolean = false
)

class InventoryViewModel(private val repository: SoloXpRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(InventoryUiState())
    val uiState: StateFlow<InventoryUiState> = _uiState.asStateFlow()

    init {
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            repository.getItems().collect { items ->
                _uiState.value = InventoryUiState(items = items, isLoading = false)
            }
        }
    }

    fun useItem(item: Item) {
        if (item.type != ItemType.CONSUMABLE) return

        viewModelScope.launch {
            val profile = repository.getUserProfile().first() ?: return@launch
            
            // Logic for specific items
            val updatedProfile = when (item.name) {
                "Essence de Feu" -> profile.copy(fireCharges = profile.fireCharges + 1)
                else -> profile
            }
            
            if (updatedProfile != profile) {
                repository.saveUserProfile(updatedProfile)
                repository.deleteItem(item)
            }
        }
    }
}
