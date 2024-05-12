package ru.shalkoff.auth

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.shalkoff.usecase.AuthUseCase
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val authUseCase: AuthUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<AuthUiState> = MutableStateFlow(
        AuthUiState.None
    )
    val uiState: StateFlow<AuthUiState> = _uiState

    fun auth(login: String, password: String) {
        viewModelScope.launch {
            _uiState.tryEmit(AuthUiState.Loading)
            try {
                val authModel = authUseCase(login, password)
                _uiState.tryEmit(AuthUiState.Success(authModel))
            } catch (e: Exception) {
                _uiState.tryEmit(AuthUiState.Error)
            }
        }
    }
}