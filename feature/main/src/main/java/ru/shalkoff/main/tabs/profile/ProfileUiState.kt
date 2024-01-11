package ru.shalkoff.main.tabs.profile

sealed interface ProfileUiState {

    object Loading: ProfileUiState
    object ShowContent: ProfileUiState
}