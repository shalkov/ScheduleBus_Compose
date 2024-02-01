package ru.shalkoff.detail

import ru.shalkoff.model.ScheduleRoute

sealed interface DetailUiState {

    data object Loading : DetailUiState
    data class Success(
        val route: ScheduleRoute
    ) : DetailUiState
}