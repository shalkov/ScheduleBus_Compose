package ru.shalkoff.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.shalkoff.main.tabs.heart.HeartTabRoute
import ru.shalkoff.main.tabs.home.HomeTabRoute
import ru.shalkoff.main.tabs.profile.ProfileTabRoute
import ru.shalkoff.ui.bottombar.DropletButtonNavBar

@Composable
fun MainRoute(
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    MainScreen(
        viewModel = viewModel,
        uiState = uiState,
        modifier = modifier
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainScreen(
    viewModel: MainViewModel,
    uiState: MainUiState,
    modifier: Modifier = Modifier
) {
    Scaffold(
        content = {
            when (uiState) {
                MainUiState.HomeTabSelected -> {
                    HomeTabRoute(onGoBack = { })
                }

                MainUiState.HeartTabSelected -> {
                    HeartTabRoute()
                }

                MainUiState.ProfileTabSelected -> {
                    ProfileTabRoute()
                }
            }
        },
        bottomBar = {
            AppBottomNavigation(viewModel)
        }
    )
}

@Composable
internal fun AppBottomNavigation(
    viewModel: MainViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            DropletButtonNavBar(
                dropletButtons = viewModel.tabs,
                onClick = { bottomItem ->
                    viewModel.onTabSelected(bottomItem)
                }
            )
        }
    }
}