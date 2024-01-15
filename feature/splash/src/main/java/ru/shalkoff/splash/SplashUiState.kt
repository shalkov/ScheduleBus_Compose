package ru.shalkoff.splash

sealed interface SplashUiState {

    data object Loading : SplashUiState
    data object Success : SplashUiState
}