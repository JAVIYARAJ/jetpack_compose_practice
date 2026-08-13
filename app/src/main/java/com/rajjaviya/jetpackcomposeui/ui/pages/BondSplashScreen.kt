package com.rajjaviya.jetpackcomposeui.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rajjaviya.jetpackcomposeui.R
import com.rajjaviya.jetpackcomposeui.ui.components.BondBrandLogoAnimation
import com.rajjaviya.jetpackcomposeui.ui.navigation.Routes
import com.rajjaviya.jetpackcomposeui.ui.theme.EduSemiBoldFonts

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

            Text("Connect your memories", fontSize = 55.sp, fontWeight = FontWeight.SemiBold, fontFamily = EduSemiBoldFonts, maxLines = 3, modifier = Modifier.padding(horizontal = 15.dp), lineHeight = 55.sp, textAlign = TextAlign.Center)

            BondBrandLogoAnimation {
                navController.navigate(Routes.BondWelcomeScreen)
            }

            Image(painter = painterResource(R.drawable.bond_app_icon), contentDescription = "logo", modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp).height(150.dp))
        }
    }
}