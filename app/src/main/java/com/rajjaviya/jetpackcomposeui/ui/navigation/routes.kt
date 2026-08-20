package com.rajjaviya.jetpackcomposeui.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {
    @Serializable
    data object SplashScreen : Routes()

    @Serializable
    data object BondAddStoryScreen : Routes()

    @Serializable
    data object BondWelcomeScreen : Routes()

    @Serializable
    data object BondDiscoverScreen : Routes()

    @Serializable
    data object BondDiscoverResultScreen : Routes()

    @Serializable
    data object BondRegisterScreen : Routes()

    @Serializable
    data object BondOtpVerificationScreen : Routes()

    @Serializable
    data object BondOnBoardingNameScreen : Routes()

    @Serializable
    data object BondOnBODScreen : Routes()

    @Serializable
    data object BondUserProfileScreen : Routes()

    @Serializable
    data object BondUserCaptureMemoryScreen : Routes()

    @Serializable
    data object BondUserIntroScreen : Routes()

    @Serializable
    data object BondProfilePreviewScreen : Routes()


    // All travel routes
    @Serializable
    data object TravelSplashScreen : Routes()

    @Serializable
    data object TravelLoginScreen : Routes()
}