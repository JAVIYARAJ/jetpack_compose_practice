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
    data class BondOtpVerificationScreen(val phoneNumber: String) : Routes()

    @Serializable
    data object BondOnBoardingNameScreen : Routes()

    @Serializable
    data object BondOnBODScreen : Routes()

    @Serializable
    data object BondUserProfileScreen : Routes()

}