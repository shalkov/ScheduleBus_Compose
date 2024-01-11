package ru.shalkoff.main

sealed interface MainUiState {

    object HomeTabSelected : MainUiState
    object HeartTabSelected : MainUiState
    object ProfileTabSelected : MainUiState
}


