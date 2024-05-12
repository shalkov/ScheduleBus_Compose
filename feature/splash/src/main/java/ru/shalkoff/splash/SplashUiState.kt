package ru.shalkoff.splash

sealed interface SplashUiState {

    data object Loading : SplashUiState
    data object Success : SplashUiState

    data object ShowAuthScreen : SplashUiState
    data object ShowMainScreen : SplashUiState
}