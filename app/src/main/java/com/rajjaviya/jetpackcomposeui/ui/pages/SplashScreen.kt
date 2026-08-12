package com.rajjaviya.jetpackcomposeui.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rajjaviya.jetpackcomposeui.R
import com.rajjaviya.jetpackcomposeui.ui.navigation.Route
import com.rajjaviya.jetpackcomposeui.ui.theme.RegularRobotoFonts
import com.rajjaviya.jetpackcomposeui.ui.theme.RegularRubikFonts

@Composable
fun SplashScreen(navController: NavHostController) {
    val backgroundColor = Color(0xFFFAF4EC)
    val primaryGreen = Color(0xFF093627)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = backgroundColor,
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 20.dp)
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryGreen
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = CircleShape,
                    onClick = {
                        navController.navigate(Route.HomeScreen)
                    }
                ) {
                    Text(
                        text = "Get Started",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = RegularRobotoFonts
                    )
                }
            }
        }
    ) { innerPadding ->
        Surface(
            color = backgroundColor,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            BoxWithConstraints(
                modifier = Modifier.fillMaxSize()
            ) {
                val screenHeight = maxHeight

                // Top Center Card
                FloatingCard(
                    imageRes = R.drawable.image_01,
                    badgeText = "Help with a decision",
                    badgeIcon = "☑️",
                    badgeColor = Color(0xFFDCEBFE),
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .offset(y = screenHeight * 0.05f)
                )

                // Top Left Card (partially offset off screen)
                FloatingCard(
                    imageRes = R.drawable.image_01,
                    badgeText = "Curiosity",
                    badgeIcon = "📚",
                    badgeColor = Color(0xFFFDE8E4),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(x = (-45).dp, y = screenHeight * 0.16f)
                )

                // Top Right Card (partially offset off screen)
                FloatingCard(
                    imageRes = R.drawable.image_01,
                    badgeText = "Untangle",
                    badgeIcon = "💬",
                    badgeColor = Color(0xFFFEEAD8),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = 45.dp, y = screenHeight * 0.16f)
                )

                // Center Title Section
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 32.dp)
                ) {
                    Text(
                        text = "Pi",
                        fontSize = 52.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        color = primaryGreen
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "the first emotionally\nintelligent AI",
                        fontSize = 22.sp,
                        fontStyle = FontStyle.Italic,
                        fontFamily = RegularRubikFonts,
                        color = primaryGreen,
                        textAlign = TextAlign.Center,
                        lineHeight = 34.sp
                    )
                }

                // Bottom Left Card (partially offset off screen)
                FloatingCard(
                    imageRes = R.drawable.image_01,
                    badgeText = "Reflect on today",
                    badgeIcon = "🌊",
                    badgeColor = Color(0xFFDDF4F5),
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .offset(x = (-45).dp, y = -(screenHeight * 0.18f))
                )

                // Bottom Right Card (partially offset off screen)
                FloatingCard(
                    imageRes = R.drawable.image_01,
                    badgeText = "Nature walk",
                    badgeIcon = "🌿",
                    badgeColor = Color(0xFFE2F1E7),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(x = 45.dp, y = -(screenHeight * 0.18f))
                )

                // Bottom Center Card
                FloatingCard(
                    imageRes = R.drawable.image_01,
                    badgeText = "Have some fun",
                    badgeIcon = "🦩",
                    badgeColor = Color(0xFFFFE3E8),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset(y = -(screenHeight * 0.06f))
                )
            }
        }
    }
}

@Composable
fun FloatingCard(
    imageRes: Int,
    badgeText: String,
    badgeIcon: String,
    badgeColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(140.dp)
                .padding(bottom = 12.dp)
                .clip(RoundedCornerShape(22.dp))
        )
        Surface(
            shape = CircleShape,
            color = badgeColor,
            shadowElevation = 0.dp,
            modifier = Modifier.offset(y = 15.dp, x = 15.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
            ) {
                Text(
                    text = badgeIcon,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = badgeText,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF2C2C2C),
                    maxLines = 1
                )
            }
        }
    }
}
