package ru.shalkoff.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.shalkoff.ui.Loading

@Composable
fun DetailRoute(
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    DetailScreen(
        uiState,
        onGoBack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    uiState: DetailUiState,
    onGoBack: () -> Unit,
) {
    when (uiState) {
        DetailUiState.Loading -> Loading()
        is DetailUiState.Success -> {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(
                                modifier = Modifier.padding(start = 16.dp),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                text = uiState.route.name
                            )
                        },
                        navigationIcon = {
                            IconButton(onGoBack, modifier = Modifier.testTag("nav_icon")) {
                                Icon(Icons.Default.ArrowBack, null)
                            }
                        }
                    )
                }
            ) { padding ->
                Row(
                    modifier =
                    Modifier
                        .padding(padding)
                        .padding(16.dp)
                        .fillMaxWidth()
                        .background(Color.Red),
                    horizontalArrangement = Arrangement.Center
                ) {
                    val timeStartList = uiState.route.departureStart.timeList
                    LazyColumn(
                        modifier = Modifier
                            .background(Color.Green)
                            .padding(6.dp),
                    ) {
                        items(timeStartList.size) {
                            Text(text = timeStartList[it].time)
                        }
                    }
                    val timeEndList = uiState.route.departureEnd.timeList
                    LazyColumn(
                        modifier = Modifier
                            .background(Color.Magenta)
                            .padding(6.dp)
                    ) {
                        items(timeEndList.size) {
                            Text(
                                modifier = Modifier.padding(4.dp),
                                text = timeEndList[it].time
                            )
                        }
                    }
                }
            }
        }
    }
}
