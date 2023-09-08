package ru.shalkoff.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ru.shalkoff.data.ScheduleRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    //TODO
    val uiState: StateFlow<MainUiState> = savedStateHandle
        .getStateFlow<Long?>("id", 1)
        .filterNotNull()
        .flatMapLatest { id ->
            scheduleRepository.observeModelById(id)
        }.map { model ->
            MainUiState.Success(
                title = model.title,
                description = model.description
            )
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            MainUiState.Loading
        )
}