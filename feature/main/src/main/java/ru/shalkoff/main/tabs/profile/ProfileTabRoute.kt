package ru.shalkoff.main.tabs.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.shalkoff.ui.Loading
import ru.shalkoff.ui.extension.observeLifecycleEvents

@Composable
fun ProfileTabRoute(
    viewModel: ProfileTabViewModel = hiltViewModel()
) {
    viewModel.observeLifecycleEvents(LocalLifecycleOwner.current.lifecycle)

    val uiState by viewModel.uiState.collectAsState()
    ProfileScreen(uiState)
}

@Composable
internal fun ProfileScreen(
    uiState: ProfileUiState
) {
    when (uiState) {
        ProfileUiState.Loading -> {
            Loading()
        }
        ProfileUiState.ShowContent -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Профиль в разработке",
                    fontSize = 16.sp
                )
            }
        }
    }
}