package com.rajjaviya.jetpackcomposeui.ui.pages

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.rajjaviya.jetpackcomposeui.ui.components.BondCommonTopBar
import com.rajjaviya.jetpackcomposeui.ui.navigation.Routes
import com.rajjaviya.jetpackcomposeui.ui.theme.BackgroundColor

@Composable
fun BondUserCaptureMemoryScreen(
    navController: NavHostController,
) {

    val selectedImages = remember { mutableStateListOf<Uri?>() }

    // register photo picket launcher
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(), onResult = { uri ->
            if (uri != null) {
                selectedImages.add(uri)
            }
        })

    Box(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            topBar = {
                BondCommonTopBar(onTap = {
                    navController.popBackStack()
                })
            }, containerColor = BackgroundColor
        ) { innerPadding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 15.dp),
            ) {
                Spacer(Modifier.fillMaxHeight(0.1f))

                // Title
                Text(
                    text = "Capture your first memory",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.W400,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF1A1A1A)
                )

                Spacer(Modifier.height(6.dp))

                // Subtitle
                Text(
                    text = "Share a memories and Bond will turn it into a recommendation for you",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.W300,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF888888)
                )

                Spacer(Modifier.height(40.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    items(
                        count = selectedImages.size,
                        key = { "key-${it}" },
                    ) { index ->
                        Box {
                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0XFFeaeaea)
                                ),
                            ) {
                                Column(
                                    modifier = Modifier.padding(8.dp)
                                ) {
                                    AsyncImage(
                                        model = selectedImages[index],
                                        contentScale = ContentScale.Crop,
                                        contentDescription = "user image",
                                        modifier = Modifier
                                            .size(250.dp)
                                            .clip(RoundedCornerShape(5.dp)),
                                    )

                                    Spacer(
                                        modifier = Modifier.height(8.dp)
                                    )

                                    Text(
                                        text = "Jun 16, 2026",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.W300,
                                        fontSize = 14.sp,
                                        textAlign = TextAlign.Center,
                                        color = Color.Black.copy(alpha = 0.5f)
                                    )
                                }
                            }
                            IconButton(
                                modifier = Modifier.align(Alignment.TopEnd), onClick = {
                                    selectedImages.removeAt(index)
                                }) {
                                Icon(Icons.Default.Cancel, contentDescription = "close")
                            }
                        }
                    }

                    item {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0XFFeaeaea)
                            ),
                        ) {
                            Column(
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Surface(
                                    modifier = Modifier.size(250.dp),
                                    shape = RoundedCornerShape(5.dp),
                                    color = Color(0XFFf5f0ef)
                                ) {
                                    TextButton(
                                        shape = RoundedCornerShape(5.dp), onClick = {
                                            // Launches the picker limited to images only
                                            singlePhotoPickerLauncher.launch(
                                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                            )
                                        }) {
                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center,
                                        ) {
                                            Text(
                                                text = if (selectedImages.isEmpty()) {
                                                    "No photo yet"
                                                } else {
                                                    "Choose more images"
                                                },
                                                style = MaterialTheme.typography.bodyMedium,
                                                fontWeight = FontWeight.W300,
                                                fontSize = 16.sp,
                                                textAlign = TextAlign.Center,
                                                color = Color.Black.copy(alpha = 0.7f)
                                            )
                                            Spacer(
                                                modifier = Modifier.height(10.dp)
                                            )

                                            Text(
                                                text = "Shares your more memories",
                                                style = MaterialTheme.typography.bodyMedium,
                                                fontWeight = FontWeight.W300,
                                                fontSize = 14.sp,
                                                textAlign = TextAlign.Center,
                                                color = Color.Black.copy(alpha = 0.5f)
                                            )
                                        }
                                    }
                                }

                                Spacer(
                                    modifier = Modifier.height(8.dp)
                                )

                                Text(
                                    text = "Jun 16, 2026",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.W300,
                                    fontSize = 14.sp,
                                    textAlign = TextAlign.Center,
                                    color = Color.Black.copy(alpha = 0.5f)
                                )
                            }
                        }
                    }
                }


            }
        }

        // FAB — above keyboard via imePadding, disabled until name is valid
        Box(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
                .padding(end = 16.dp, bottom = 16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            val fabColor by animateColorAsState(
                targetValue = if (selectedImages.isNotEmpty()) Color.Black else Color(0xFFCCCCCC),
                animationSpec = tween(300),
                label = "fabColor"
            )
            IconButton(
                enabled = selectedImages.isNotEmpty(), colors = IconButtonDefaults.iconButtonColors(
                    containerColor = fabColor,
                    contentColor = Color.White,
                    disabledContainerColor = fabColor,
                    disabledContentColor = Color.White,
                ), shape = CircleShape, modifier = Modifier.size(55.dp), onClick = {
                    navController.navigate(Routes.BondUserIntroScreen)
                }) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next"
                )
            }
        }

    }
}
