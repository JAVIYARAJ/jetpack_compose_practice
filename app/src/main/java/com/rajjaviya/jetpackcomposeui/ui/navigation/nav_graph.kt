package com.rajjaviya.jetpackcomposeui.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rajjaviya.jetpackcomposeui.ui.components.BondBODScreen
import com.rajjaviya.jetpackcomposeui.ui.components.BondOnBoardingNameScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondDiscoverResultScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondDiscoverScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondOtpVerificationScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondRegisterScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondSplashScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondUserCaptureMemoryScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondUserIntroScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondUserProfileScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.BondWelcomeScreen
import com.rajjaviya.jetpackcomposeui.ui.viewmodel.BondOnBoardingViewModel

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

        composable<Routes.BondRegisterScreen> { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(
                    Routes.BondRegisterScreen
                )
            }

            val viewModel: BondOnBoardingViewModel = viewModel(
                viewModelStoreOwner = parentEntry
            )
            BondRegisterScreen(navController = navController, viewModel = viewModel)
        }

        composable<Routes.BondOtpVerificationScreen> { backStackEntry ->
            // Scope to BondRegisterScreen's entry so the SAME ViewModel
            // instance is shared between Register and OTP screens.
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(
                    Routes.BondRegisterScreen
                )
            }

            val viewModel: BondOnBoardingViewModel = viewModel(
                viewModelStoreOwner = parentEntry
            )
            BondOtpVerificationScreen(
                navController = navController, viewModel = viewModel
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

        composable<Routes.BondUserCaptureMemoryScreen> {
            BondUserCaptureMemoryScreen(navController = navController)
        }

        composable<Routes.BondUserIntroScreen> {
            BondUserIntroScreen(navController = navController)
        }
    }
}