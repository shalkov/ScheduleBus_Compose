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
import ru.shalkoff.usecase.GetCatsUseCase
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getCatsUseCase: GetCatsUseCase
) : ViewModel(), DefaultLifecycleObserver {

    private var _uiState = MutableStateFlow<ProfileUiState>(
        ProfileUiState.Loading
    )
    val uiState: StateFlow<ProfileUiState> = _uiState

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.tryEmit(ProfileUiState.Loading)
            val cats = getCatsUseCase(10)
            _uiState.tryEmit(ProfileUiState.ShowContent(cats))
        }
    }
}