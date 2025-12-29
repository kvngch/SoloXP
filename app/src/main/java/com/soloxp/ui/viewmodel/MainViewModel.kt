package com.soloxp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soloxp.data.repository.SoloXpRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

sealed class AppStartupState {
    object Loading : AppStartupState()
    object OnboardingRequired : AppStartupState()
    object DashboardReady : AppStartupState()
}

class MainViewModel(private val repository: SoloXpRepository) : ViewModel() {
    private val _startupState = MutableStateFlow<AppStartupState>(AppStartupState.Loading)
    val startupState: StateFlow<AppStartupState> = _startupState.asStateFlow()

    init {
        checkProfile()
    }

    private fun checkProfile() {
        viewModelScope.launch {
            val profile = repository.getUserProfile().first()
            if (profile != null) {
                _startupState.value = AppStartupState.DashboardReady
            } else {
                _startupState.value = AppStartupState.OnboardingRequired
            }
        }
    }

    fun completeOnboarding() {
        _startupState.value = AppStartupState.DashboardReady
    }
}
