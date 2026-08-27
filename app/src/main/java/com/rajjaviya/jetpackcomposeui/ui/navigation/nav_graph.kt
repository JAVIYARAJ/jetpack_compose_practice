package com.rajjaviya.jetpackcomposeui.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rajjaviya.jetpackcomposeui.ui.components.BondBODScreen
import com.rajjaviya.jetpackcomposeui.ui.components.BondOnBoardingNameScreen
import com.rajjaviya.jetpackcomposeui.ui.core.datastore.DataStoreModule
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
import com.rajjaviya.jetpackcomposeui.ui.pages.TravelSplashScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.TravelLoginScreen
import com.rajjaviya.jetpackcomposeui.ui.pages.UserProfilePreviewScreen
import com.rajjaviya.jetpackcomposeui.ui.viewmodel.BondOnBoardingViewModel
import com.rajjaviya.jetpackcomposeui.ui.viewmodel.SplashScreenViewModel
import com.rajjaviya.jetpackcomposeui.ui.viewmodel.SplashViewModelFactory
import com.rajjaviya.jetpackcomposeui.ui.viewmodel.WelcomeScreenViewModel
import com.rajjaviya.jetpackcomposeui.ui.viewmodel.WelcomeScreenViewModelFactory

/**
 * Returns a [BondOnBoardingViewModel] scoped to the [Routes.BondRegisterScreen] back-stack entry,
 * so the SAME instance is shared across all screens in the Bond onboarding flow
 * (Register → OTP → ...).
 *
 * Any new screen added to this flow just needs to call this helper instead of
 * repeating the remember + getBackStackEntry + viewModel boilerplate.
 */
@Composable
private fun NavBackStackEntry.bondOnBoardingViewModel(
    navController: NavHostController
): BondOnBoardingViewModel {
    val parentEntry = remember(this) {
        navController.getBackStackEntry(Routes.BondRegisterScreen)
    }
    return viewModel(viewModelStoreOwner = parentEntry)
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navController: NavHostController) {

    val context = LocalContext.current

    val dataStore = remember {
        DataStoreModule(context)
    }

    NavHost(navController = navController, startDestination = Routes.TravelSplashScreen) {


        composable<Routes.SplashScreen> {
            val viewModel: SplashScreenViewModel = viewModel(
                factory = SplashViewModelFactory(
                    dataStoreModule = dataStore
                )
            )

            BondSplashScreen(navController = navController, viewModel = viewModel)
        }

        composable<Routes.BondAddStoryScreen> {
            BondScreen()
        }

        composable<Routes.BondWelcomeScreen> {

            val viewModel: WelcomeScreenViewModel = viewModel(
                factory = WelcomeScreenViewModelFactory(
                    dataStoreModule = dataStore
                )
            )

            BondWelcomeScreen(
                navController = navController, viewModel = viewModel
            )
        }

        composable<Routes.BondDiscoverScreen> {
            BondDiscoverScreen()
        }

        composable<Routes.BondDiscoverResultScreen> {
            BondDiscoverResultScreen()
        }

        composable<Routes.BondRegisterScreen> { backStackEntry ->
            BondRegisterScreen(
                navController = navController,
                viewModel = backStackEntry.bondOnBoardingViewModel(navController)
            )
        }

        composable<Routes.BondOtpVerificationScreen> { backStackEntry ->
            BondOtpVerificationScreen(
                navController = navController,
                viewModel = backStackEntry.bondOnBoardingViewModel(navController)
            )
        }

        composable<Routes.BondOnBoardingNameScreen> { backStackEntry ->
            BondOnBoardingNameScreen(
                navController = navController,
                viewModel = backStackEntry.bondOnBoardingViewModel(navController)
            )
        }

        composable<Routes.BondOnBODScreen> { backStackEntry ->
            BondBODScreen(
                navController = navController,
                viewModel = backStackEntry.bondOnBoardingViewModel(navController)
            )
        }

        composable<Routes.BondUserProfileScreen> { backStackEntry ->
            BondUserProfileScreen(
                navController = navController,
                viewModel = backStackEntry.bondOnBoardingViewModel(navController)
            )
        }

        composable<Routes.BondUserCaptureMemoryScreen> { backStackEntry ->
            BondUserCaptureMemoryScreen(
                navController = navController,
                viewModel = backStackEntry.bondOnBoardingViewModel(navController)
            )
        }

        composable<Routes.BondUserIntroScreen> { backStackEntry ->
            BondUserIntroScreen(
                navController = navController,
                viewModel = backStackEntry.bondOnBoardingViewModel(navController)
            )
        }

        composable<Routes.BondProfilePreviewScreen> { backStackEntry ->
            UserProfilePreviewScreen(
                navController = navController,
                viewModel = backStackEntry.bondOnBoardingViewModel(navController)
            )
        }

        // All travel routes composables
        composable<Routes.TravelSplashScreen>{
            TravelSplashScreen(
                onLoginClick = { navController.navigate(Routes.TravelLoginScreen) }
            )
        }

        composable<Routes.TravelLoginScreen> {
            TravelLoginScreen(
                onBackClick = { navController.popBackStack() },
                onCreateAccountClick = { /* TODO: navigate to register */ }
            )
        }
    }
}