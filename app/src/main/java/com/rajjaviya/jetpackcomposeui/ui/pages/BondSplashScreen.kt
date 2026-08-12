package com.rajjaviya.jetpackcomposeui.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rajjaviya.jetpackcomposeui.ui.components.BondBrandLogoAnimation
import com.rajjaviya.jetpackcomposeui.ui.components.BondBrandName
import com.rajjaviya.jetpackcomposeui.ui.navigation.Route
import com.rajjaviya.jetpackcomposeui.ui.theme.RegularRubikFonts

@Composable
fun BondSplashScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            BondBrandLogoAnimation {
                navController.navigate(Route.BondWelcomeScreen)
            }
            BondBrandName()
        }
    }
}