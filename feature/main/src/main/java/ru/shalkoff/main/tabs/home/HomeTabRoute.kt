package ru.shalkoff.main.tabs.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    openDetailScreen: (String) -> Unit,
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    HomeScreen(
        openDetailScreen,
        state,
        onGoBack,
        modifier
    )
}

@Composable
internal fun HomeScreen(
    openDetailScreen: (String) -> Unit,
    state: HomeUiState,
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (state) {
        HomeUiState.Loading -> Loading(modifier)
        is HomeUiState.ShowContent -> Content(
            openDetailScreen,
            state,
            onGoBack,
            modifier
        )
    }
}

@Composable
internal fun Content(
    openDetailScreen: (String) -> Unit,
    state: HomeUiState.ShowContent,
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.Top
    ) {
        items(count = state.schedules.routes.size) {
            ScheduleItem(
                openDetailScreen,
                state.schedules.routes[it]
            )
        }
    }
}

@Composable
fun ScheduleItem(
    openDetailScreen: (String) -> Unit,
    route: ScheduleRoute
) {
    Row(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .background(Color.LightGray)
            .padding(horizontal = 8.dp)
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .clickable {
                openDetailScreen(route.routeNumber)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(end = 8.dp),
            text = route.routeNumber,
            fontSize = 24.sp
        )
        Column {
            Text(
                fontSize = 18.sp,
                text = route.name
            )
            if (route.description != "") {
                Text(
                    fontSize = 14.sp,
                    text = route.description
                )
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
        openDetailScreen = { },
        onGoBack = { }
    )
}