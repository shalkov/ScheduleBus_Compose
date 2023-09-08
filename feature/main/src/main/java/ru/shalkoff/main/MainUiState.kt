package ru.shalkoff.main

sealed interface MainUiState {
    object Loading : MainUiState
    data class Success(
        val title: String,
        val description: String
    ) : MainUiState
}