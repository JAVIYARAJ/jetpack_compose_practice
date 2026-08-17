package com.rajjaviya.jetpackcomposeui.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.rajjaviya.jetpackcomposeui.ui.components.BondBODScreen
import com.rajjaviya.jetpackcomposeui.ui.components.BondOnBoardingNameScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondDiscoverResultScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondDiscoverScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondOtpVerificationScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondRegisterScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondSplashScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondUserProfileScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondWelcomeScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.SplashScreen) {

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

        composable<Routes.BondDiscoverResultScreen> {
            BondDiscoverResultScreen()
        }

        composable<Routes.BondRegisterScreen> {
            BondRegisterScreen(navController = navController)
        }

        composable<Routes.BondOtpVerificationScreen> { backStackEntry ->
            val route = backStackEntry.toRoute<Routes.BondOtpVerificationScreen>()
            BondOtpVerificationScreen(
                navController = navController, phoneNumber = route.phoneNumber
            )
        }

        composable<Routes.BondOnBoardingNameScreen> {
            BondOnBoardingNameScreen(navController = navController)
        }

        composable<Routes.BondOnBODScreen> {
            BondBODScreen(navController = navController)
        }

        composable<Routes.BondUserProfileScreen> {
            BondUserProfileScreen(navController = navController)
        }
    }
}