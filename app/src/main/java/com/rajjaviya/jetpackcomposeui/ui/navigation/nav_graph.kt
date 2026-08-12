package com.rajjaviya.jetpackcomposeui.ui.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rajjaviya.jetpackcomposeui.ui.pages.BondScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondSplashScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondWelcomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Route.SplashScreen) {

        composable<Route.SplashScreen> {
            BondSplashScreen(navController = navController)
        }

        composable<Route.BondScreen> {
            BondScreen()
        }

        composable<Route.BondWelcomeScreen> {
            BondWelcomeScreen(navController = navController)
        }

    }
}