package com.rajjaviya.jetpackcomposeui.ui.pages

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.rajjaviya.jetpackcomposeui.ui.components.BondCommonTopBar
import com.rajjaviya.jetpackcomposeui.ui.components.BondOtpField
import com.rajjaviya.jetpackcomposeui.ui.core.extensions.orDefault
import com.rajjaviya.jetpackcomposeui.ui.navigation.Routes
import com.rajjaviya.jetpackcomposeui.ui.theme.BackgroundColor
import com.rajjaviya.jetpackcomposeui.ui.viewmodel.BondOnBoardingViewModel

@Composable
fun BondOtpVerificationScreen(
    navController: NavHostController,
    viewModel: BondOnBoardingViewModel,
) {

    val state by viewModel.uiState.collectAsStateWithLifecycle()


    var otp by rememberSaveable {
        mutableStateOf("")
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            topBar = {
                BondCommonTopBar(onTap = {
                    navController.popBackStack()
                })
            },
            containerColor = BackgroundColor
        ) { innerPadding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 20.dp),
            ) {
                Spacer(
                    Modifier.fillMaxHeight(0.2f)
                )

                Text(
                    "Enter the code we sent to ${state.phoneNumber.orDefault()}",
                    modifier = Modifier.padding(horizontal = 20.dp),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.W200,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(
                    modifier = Modifier.height(25.dp)
                )

                BondOtpField(otp = otp, onOtpChange = {
                    otp = it
                }, length = 6)

                Spacer(
                    modifier = Modifier.height(15.dp)
                )

                val buildString = buildAnnotatedString {
                    append("A 6 digit code was sent to your phone number.\n Didn't get it? ")

                    val clickableLink = LinkAnnotation.Clickable(
                        tag = "Resend",
                        linkInteractionListener = {

                        }
                    )



                    withLink(clickableLink) {
                        append("Resend")
                    }

                }

                Text(buildString, textAlign = TextAlign.Center)

            }
        }

        // FAB placed outside Scaffold so imePadding() pushes it
        // above the keyboard instead of hiding it
        Box(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()                        // ← moves up when keyboard opens
                .padding(end = 16.dp, bottom = 16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            val fabColor by animateColorAsState(
                targetValue = if (otp.isNotEmpty()) Color.Black else Color(0xFFCCCCCC),
                animationSpec = tween(300),
                label = "fabColor"
            )

            IconButton(
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = fabColor,
                    contentColor = Color.White,
                    disabledContainerColor = fabColor,
                    disabledContentColor = Color.White,
                ),
                shape = CircleShape,
                modifier = Modifier.size(55.dp),
                onClick = {
                    if (otp.isNotEmpty()) {
                        navController.navigate(Routes.BondOnBoardingNameScreen)
                    }
                }
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Next action"
                )
            }
        }
    }
}