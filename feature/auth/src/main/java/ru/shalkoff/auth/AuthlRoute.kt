package ru.shalkoff.auth


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AuthRoute(
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    AuthScreen(
        uiState,
        onGoBack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(
    uiState: AuthUiState,
    onGoBack: () -> Unit,
) {
    when (uiState) {
        is AuthUiState.Error -> {

        }
        is AuthUiState.Loading -> {

        }
        is AuthUiState.None -> {
            Text(
                text = "Экран авторизации",
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
        is AuthUiState.Success -> {
            Text(
                text = "Авторизация прошла успешно",
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
    }
}
