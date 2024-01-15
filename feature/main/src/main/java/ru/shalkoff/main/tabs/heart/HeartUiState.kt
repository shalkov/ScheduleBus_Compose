package ru.shalkoff.main.tabs.heart

sealed interface HeartUiState {

    data object Loading : HeartUiState
    data object ShowContent : HeartUiState
}