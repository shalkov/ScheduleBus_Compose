package ru.shalkoff.main.tabs.heart

sealed interface HeartUiState {

    object Loading : HeartUiState
    object ShowContent : HeartUiState
}