package ru.shalkoff.main.tabs.profile

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileTabViewModel @Inject constructor() : ViewModel(), DefaultLifecycleObserver {

    private var _uiState = MutableStateFlow<ProfileUiState>(
        ProfileUiState.Loading
    )
    val uiState: StateFlow<ProfileUiState> = _uiState

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        viewModelScope.launch {
            _uiState.tryEmit(ProfileUiState.Loading)
            delay(1000)
            _uiState.tryEmit(ProfileUiState.ShowContent)
        }
    }
}