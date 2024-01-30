package ru.shalkoff.main.tabs.home

import ru.shalkoff.model.Schedules

sealed interface HomeUiState {

    data object Loading : HomeUiState
    data class ShowContent(
        val schedules: Schedules
    ) : HomeUiState
}