package ru.shalkoff.main.tabs.profile

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.shalkoff.data.ScheduleRepository
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: ScheduleRepository
) : ViewModel(), DefaultLifecycleObserver {

    private var _uiState = MutableStateFlow<ProfileUiState>(
        ProfileUiState.Loading
    )
    val uiState: StateFlow<ProfileUiState> = _uiState

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.tryEmit(ProfileUiState.Loading)
            val cats = repository.getCats(10)
            _uiState.tryEmit(ProfileUiState.ShowContent(cats))
        }
    }
}