package ru.shalkoff.main.tabs.home

sealed interface HomeUiState {

    object Loading : HomeUiState
    data class Success(
        val title: String,
        val description: String
    ) : HomeUiState
}