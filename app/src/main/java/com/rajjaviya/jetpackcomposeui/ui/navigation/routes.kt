package com.rajjaviya.jetpackcomposeui.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Route {
    @Serializable
    data object SplashScreen : Route()
    @Serializable
    data object HomeScreen : Route()
}