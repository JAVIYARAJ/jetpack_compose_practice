package com.rajjaviya.jetpackcomposeui.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Route {
    @Serializable
    data object SplashScreen : Route()
    @Serializable
    data object HomeScreen : Route()

    @Serializable
    data object BondScreen : Route()

    @Serializable
    data object BondWelcomeScreen : Route()
}