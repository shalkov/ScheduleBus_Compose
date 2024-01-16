package ru.shalkoff.main.tabs.profile

import ru.shalkoff.model.Cat

sealed interface ProfileUiState {

    data object Loading: ProfileUiState
    data class ShowContent(
        val cats: List<Cat>
    ): ProfileUiState
}