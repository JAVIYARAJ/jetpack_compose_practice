package com.rajjaviya.jetpackcomposeui.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajjaviya.jetpackcomposeui.R
import com.rajjaviya.jetpackcomposeui.ui.theme.OsWaldBold
import com.rajjaviya.jetpackcomposeui.ui.theme.OsWaldMedium
import com.rajjaviya.jetpackcomposeui.ui.theme.OsWaldRegular


@Composable
fun TravelSplashScreen(modifier: Modifier = Modifier, onLoginClick: () -> Unit = {}) {

    val buildString = buildAnnotatedString {
        append("Already have an account? ")

        val clickable = LinkAnnotation.Clickable(
            tag = "login",
            styles = TextLinkStyles(
                style = SpanStyle(
                    color = Color.White
                )
            ),
            linkInteractionListener = {
                onLoginClick()
            }
        )

        withLink(clickable) {
            append("Login")
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.ic_travel_splash_01),
            contentDescription = "full_image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            color = Color.Transparent
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Text(
                    "Explore the world",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontFamily = OsWaldMedium,
                    fontSize = 25.sp
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    "Plan your journey, organize every detail, and make every trip memorable.",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontFamily = OsWaldRegular,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {

                    }) {
                    Text(
                        "Get started",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontFamily = OsWaldBold,
                        modifier = Modifier.padding(5.dp),
                    )
                }

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    buildString,
                    color = Color.White,
                    fontFamily = OsWaldRegular,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W300,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.windowInsetsPadding(WindowInsets.safeDrawing)
                )
            }
        }
    }
}