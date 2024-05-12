package ru.shalkoff.schedulebus

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.shalkoff.R
import ru.shalkoff.auth.AuthRoute
import ru.shalkoff.detail.DetailRoute
import ru.shalkoff.main.MainRoute
import ru.shalkoff.splash.SplashRoute

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashRoute(
                R.raw.splash_logo,
                openMainScreen = {
                    navController.navigate("main") {
                        // удаление экрана из стека навигации
                        popUpTo("splash") { inclusive = true }
                    }
                },
                openAuthScreen = {
                    navController.navigate("auth") {
                        // удаление экрана из стека навигации
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }
        composable("main") {
            MainRoute(
                openDetailScreen = { routeNumber ->
                    navController.navigate("detail/${routeNumber}")
                },
                onGoBack = {
                    navController.popBackStack()
                }
            )
        }
        composable("detail/{routeNumber}") {
            DetailRoute(
                onGoBack = {
                    navController.popBackStack()
                }
            )
        }
        composable("auth") {
            AuthRoute(onGoBack = { /*TODO*/ })
        }
    }
}