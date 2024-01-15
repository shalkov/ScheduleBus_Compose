package ru.shalkoff.main

sealed interface MainUiState {

    data object HomeTabSelected : MainUiState
    data object HeartTabSelected : MainUiState
    data object ProfileTabSelected : MainUiState
}


