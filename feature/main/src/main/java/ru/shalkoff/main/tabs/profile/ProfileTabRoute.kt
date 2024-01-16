package ru.shalkoff.main.tabs.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import ru.shalkoff.ui.Loading
import ru.shalkoff.ui.extension.observeLifecycleEvents

@Composable
fun ProfileTabRoute(
    innerPaddingValues: PaddingValues,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    viewModel.observeLifecycleEvents(LocalLifecycleOwner.current.lifecycle)

    val uiState by viewModel.uiState.collectAsState()
    ProfileScreen(
        innerPaddingValues,
        uiState
    )
}

@Composable
internal fun ProfileScreen(
    innerPaddingValues: PaddingValues,
    uiState: ProfileUiState
) {
    when (uiState) {
        is ProfileUiState.Loading -> {
            Loading()
        }

        is ProfileUiState.ShowContent -> {
            LazyColumn(
                modifier = Modifier
                    .padding(
                        bottom = innerPaddingValues.calculateBottomPadding()
                    )

            ) {
                items(count = uiState.cats.size) {
                    SubcomposeAsyncImage(
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(8.dp)
                            .height(256.dp)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(16.dp, 16.dp, 16.dp, 16.dp))
                            .background(Color.LightGray),
                        model = uiState.cats[it].url,
                        loading = {
                            Loading()
                        },
                        contentDescription = "The delasign logo"
                    )
                }
            }
        }
    }
}