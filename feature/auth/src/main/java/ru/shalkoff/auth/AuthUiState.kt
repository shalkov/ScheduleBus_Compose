package ru.shalkoff.auth

import ru.shalkoff.model.AuthModel

sealed interface AuthUiState {

    data object None : AuthUiState
    data object Loading : AuthUiState
    data object Error : AuthUiState
    data class Success(
        val authModel: AuthModel
    ) : AuthUiState
}