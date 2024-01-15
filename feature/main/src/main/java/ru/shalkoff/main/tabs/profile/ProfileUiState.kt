package ru.shalkoff.main.tabs.profile

import ru.shalkoff.network.CatResponse

sealed interface ProfileUiState {

    object Loading: ProfileUiState
    data class ShowContent(
        val cats: List<CatResponse>
    ): ProfileUiState
}