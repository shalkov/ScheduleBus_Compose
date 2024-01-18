package ru.shalkoff.main.tabs.home

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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.shalkoff.ui.Loading

@Composable
fun HomeTabRoute(
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    HomeScreen(state, onGoBack, modifier)
}

@Composable
internal fun HomeScreen(
    state: HomeUiState,
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (state) {
        HomeUiState.Loading -> Loading(modifier)
        is HomeUiState.Success -> Content(state, onGoBack, modifier)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun Content(
    state: HomeUiState.Success,
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    modifier = Modifier.padding(start = 16.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    text = state.title
                ) },
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

@Preview
@Composable
fun HomeTabRoutePreview() {
    HomeScreen(
        state = HomeUiState.Success(
            title = "Очень длинный заголовок, который не вмещается",
            description = "Описание"
        ),
        onGoBack = { }
    )
}