package ru.shalkoff.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.shalkoff.ui.bottombar.BottomNavItem
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val tabs = listOf(
        BottomNavItem.HomeTabItem,
        BottomNavItem.HeartTabItem,
        BottomNavItem.ProfileTabItem
    )

    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.HomeTabSelected)
    val uiState: StateFlow<MainUiState> = _uiState

    fun onTabSelected(tab: BottomNavItem) {
        _uiState.value = tab.mapToEvent()
    }

    private fun BottomNavItem.mapToEvent(): MainUiState {
        return when (this) {
            BottomNavItem.HomeTabItem -> MainUiState.HomeTabSelected
            BottomNavItem.HeartTabItem -> MainUiState.HeartTabSelected
            BottomNavItem.ProfileTabItem -> MainUiState.ProfileTabSelected
        }
    }
}