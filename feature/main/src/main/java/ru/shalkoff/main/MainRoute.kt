package ru.shalkoff.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.hilt.navigation.compose.hiltViewModel
import ru.shalkoff.ui.Loading

@Composable
fun MainRoute(
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    MainScreen(state, onGoBack, modifier)
}

@Composable
internal fun MainScreen(
    state: MainUiState,
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (state) {
        MainUiState.Loading -> Loading(modifier)
        is MainUiState.Success -> Content(state, onGoBack, modifier)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun Content(
    state: MainUiState.Success,
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(state.title) },
                navigationIcon = {
                    IconButton(onGoBack, modifier = Modifier.testTag("nav_icon")) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                }
            )
        },
        modifier = modifier
    ) { padding ->
        Text(state.description, Modifier.padding(padding))
    }
}