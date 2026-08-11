package com.rajjaviya.jetpackcomposeui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rajjaviya.jetpackcomposeui.ui.pages.HomeScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Route.SplashScreen){

        composable<Route.SplashScreen> {
            SplashScreen()
        }

        composable<Route.HomeScreen> {
            HomeScreen()
        }

    }
}