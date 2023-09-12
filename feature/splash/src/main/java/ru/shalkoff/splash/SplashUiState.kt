package ru.shalkoff.splash

sealed interface SplashUiState {
    object Loading : SplashUiState
    object Success : SplashUiState
}