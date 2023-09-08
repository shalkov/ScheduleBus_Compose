package ru.shalkoff.schedulebus

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.shalkoff.main.MainRoute

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = "details") {
        composable("details") {
            MainRoute(
                onGoBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}