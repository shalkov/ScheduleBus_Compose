package ru.shalkoff.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.shalkoff.usecase.GetRouteByNumberUseCase
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getRouteByNumberUseCase: GetRouteByNumberUseCase
) : ViewModel() {

    private val routeNumber: String = checkNotNull(savedStateHandle["routeNumber"])

    private val _uiState: MutableStateFlow<DetailUiState> = MutableStateFlow(
        DetailUiState.Loading
    )

    val uiState: StateFlow<DetailUiState> = _uiState

    init {
        viewModelScope.launch {
            val route = getRouteByNumberUseCase(routeNumber).route
            route?.let {
                _uiState.tryEmit(DetailUiState.Success(it))
            }
        }
    }
}