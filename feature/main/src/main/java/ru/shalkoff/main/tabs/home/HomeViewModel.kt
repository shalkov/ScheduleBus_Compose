package ru.shalkoff.main.tabs.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val _uiState = MutableStateFlow<HomeUiState>(
        HomeUiState.Loading
    )
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        viewModelScope.launch {
            delay(2000)
            _uiState.tryEmit(HomeUiState.Success(
                title = "Заголовок",
                description = "Описание"
            ))
        }
    }
}