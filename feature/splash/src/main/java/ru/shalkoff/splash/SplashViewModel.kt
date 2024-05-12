package ru.shalkoff.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.shalkoff.usecase.GetTokensUseCase
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getTokensUseCase: GetTokensUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<SplashUiState>(
        SplashUiState.Loading
    )
    val uiState: StateFlow<SplashUiState> = _uiState

    init {
        viewModelScope.launch {
           delay(2000) // эмитация запроса в сеть
           _uiState.tryEmit(SplashUiState.Success)
        }
    }

    fun openNextScreen() {
        viewModelScope.launch {
            val tokens = getTokensUseCase()
            if (tokens != null) {
                // открываем главный экран
                _uiState.tryEmit(SplashUiState.ShowMainScreen)
            } else {
                _uiState.tryEmit(SplashUiState.ShowAuthScreen)
            }
        }
    }
}