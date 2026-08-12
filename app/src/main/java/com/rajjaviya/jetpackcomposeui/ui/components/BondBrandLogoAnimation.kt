package com.rajjaviya.jetpackcomposeui.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.rajjaviya.jetpackcomposeui.R

@Composable
fun BondBrandLogoAnimation(onAnimationCompleted: () -> Unit) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.ic_clouds_animation))

    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = 1
    )

    LaunchedEffect(progress) {
        if (progress == 1f) {
            onAnimationCompleted()
        }
    }

    LottieAnimation(
        composition = composition,
        modifier = Modifier.height(250.dp),
        iterations = LottieConstants.IterateForever,
    )

}
