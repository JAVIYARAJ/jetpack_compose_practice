package com.rajjaviya.jetpackcomposeui.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rajjaviya.jetpackcomposeui.ui.components.BondBrandLogoAnimation
import com.rajjaviya.jetpackcomposeui.ui.components.BondBrandName
import com.rajjaviya.jetpackcomposeui.ui.navigation.Route

@Composable
fun BondWelcomeScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            Column {

                PrivacyContent()

                Spacer(Modifier.height(15.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    onClick = {
                        navController.navigate(Route.BondScreen)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    shape = RoundedCornerShape(32.dp),
                ) {
                    Text(
                        "Continue",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.W500,
                        ),
                        lineHeight = 10.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Spacer(
                    Modifier.height(20.dp)
                )
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            BondBrandLogoAnimation {

            }

            BondBrandName()

        }
    }
}

@Preview
@Composable
fun PrivacyContent() {
    val buildFullString = buildAnnotatedString {

        append("By continue you accept our ")

        val privacyClickableLink = LinkAnnotation.Clickable(
            tag = "Privacy",
            styles = TextLinkStyles(
                style = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
            ),
            linkInteractionListener = {

            }
        )

        // 2. Define the styling and action for the clickable part
        val termsClickableLink = LinkAnnotation.Clickable(
            tag = "Terms",
            styles = TextLinkStyles(
                style = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
            ),
            linkInteractionListener = {

            }
        )

        // 3. Attach the clickable annotation to the specific text block
        withLink(privacyClickableLink) {
            append("Privacy Policy")
        }

        append(" & ")

        withLink(termsClickableLink) {
            append("Terms of Service")
        }

    }

    Text(
        buildFullString,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(horizontal = 15.dp),
        textAlign = TextAlign.Center
    )
}