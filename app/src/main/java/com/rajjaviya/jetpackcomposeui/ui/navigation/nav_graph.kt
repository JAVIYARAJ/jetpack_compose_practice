package com.rajjaviya.jetpackcomposeui.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rajjaviya.jetpackcomposeui.ui.pages.BondDiscoverScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondSplashScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondWelcomeScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.BondDiscoverScreen) {

        composable<Routes.SplashScreen> {
            BondSplashScreen(navController = navController)
        }

        composable<Routes.BondAddStoryScreen> {
            BondScreen()
        }

        composable<Routes.BondWelcomeScreen> {
            BondWelcomeScreen(navController = navController)
        }

        composable<Routes.BondDiscoverScreen> {
            BondDiscoverScreen()
        }

    }
}