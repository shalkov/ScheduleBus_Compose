package ru.shalkoff.main.tabs.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.shalkoff.model.DepartureInfo
import ru.shalkoff.model.ScheduleRoute
import ru.shalkoff.model.Schedules
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
        is HomeUiState.ShowContent -> Content(state, onGoBack, modifier)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun Content(
    state: HomeUiState.ShowContent,
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        text = "Тест"
                    )
                },
                navigationIcon = {
                    IconButton(onGoBack, modifier = Modifier.testTag("nav_icon")) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                }
            )
        },
        modifier = modifier
    ) { padding ->
        LazyColumn(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(padding)
        ) {
            items(count = state.schedules.routes.size) {
                Row(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .background(Color.LightGray)
                        .padding(horizontal = 8.dp)
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(end = 8.dp),
                        text = state.schedules.routes[it].routeNumber,
                        fontSize = 24.sp
                    )
                    Column {
                        Text(
                            fontSize = 18.sp,
                            text = state.schedules.routes[it].name
                        )
                        if (state.schedules.routes[it].description != "") {
                            Text(
                                fontSize = 14.sp,
                                text = state.schedules.routes[it].description
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeTabRoutePreview() {
    HomeScreen(
        state = HomeUiState.ShowContent(
            schedules = Schedules(
                routes = listOf(
                    ScheduleRoute(
                        0,
                        "310",
                        "Графское - Воронеж",
                        "Едет через кочки, по хорошим дорогам",
                        DepartureInfo(
                            0, "", listOf()
                        ),
                        DepartureInfo(
                            0, "", listOf()
                        )
                    ),
                    ScheduleRoute(
                        0,
                        "371",
                        "Орлово - Воронеж",
                        "Едет через кочки, по хорошим дорогам",
                        DepartureInfo(
                            0, "", listOf()
                        ),
                        DepartureInfo(
                            0, "", listOf()
                        )
                    )
                )
            )
        ),
        onGoBack = { }
    )
}