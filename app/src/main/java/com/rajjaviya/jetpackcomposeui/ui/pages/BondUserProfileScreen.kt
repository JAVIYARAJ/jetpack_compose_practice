package com.rajjaviya.jetpackcomposeui.ui.pages


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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.rajjaviya.jetpackcomposeui.ui.components.BondCommonTopBar
import com.rajjaviya.jetpackcomposeui.ui.navigation.Routes
import com.rajjaviya.jetpackcomposeui.ui.theme.BackgroundColor
import com.rajjaviya.jetpackcomposeui.ui.viewmodel.BondOnBoardingViewModel

@Composable
fun BondUserProfileScreen(
    navController: NavHostController,
    viewModel: BondOnBoardingViewModel,
) {

    val viewModelState by viewModel.uiState.collectAsStateWithLifecycle()

    // register photo picket launcher
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> viewModel.updateProfileImage(uri) }
    )

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
                    .padding(horizontal = 32.dp),
            ) {
                Spacer(Modifier.fillMaxHeight(0.1f))

                // Title
                Text(
                    text = "Add a profile photo",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.W400,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF1A1A1A)
                )

                Spacer(Modifier.height(6.dp))

                // Subtitle
                Text(
                    text = "Add a profile picture so your friends know it's you. Everyone will be able to see your picture",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.W300,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF888888)
                )

                Spacer(Modifier.height(40.dp))

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0XFFeaeaea)
                    ),
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        if (viewModelState.profileImage != null) {
                            AsyncImage(
                                model = viewModelState.profileImage,
                                contentScale = ContentScale.Crop,
                                contentDescription = "user image",
                                modifier = Modifier
                                    .size(250.dp)
                                    .clip(CircleShape),
                            )
                        } else {
                            Surface(
                                modifier = Modifier
                                    .size(250.dp),
                                shape = CircleShape,
                                color = Color(0XFFf5f0ef)
                            ) {
                                TextButton(
                                    onClick = {
                                        // Launches the picker limited to images only
                                        singlePhotoPickerLauncher.launch(
                                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                        )
                                    }
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,
                                    ) {
                                        Text(
                                            text = "No photo yet",
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
                                            text = "Add profile photo to get started",
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

                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        Text(
                            text = "@javiyaraj-48d",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.W300,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            color = Color.Black.copy(alpha = 0.7f)
                        )
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
                targetValue = if (viewModelState.profileImage != null) Color.Black else Color(
                    0xFFCCCCCC
                ),
                animationSpec = tween(300),
                label = "fabColor"
            )
            IconButton(
                enabled = viewModelState.profileImage != null,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = fabColor,
                    contentColor = Color.White,
                    disabledContainerColor = fabColor,
                    disabledContentColor = Color.White,
                ),
                shape = CircleShape,
                modifier = Modifier.size(55.dp),
                onClick = {
                    navController.navigate(Routes.BondUserCaptureMemoryScreen)
                }
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Next"
                )
            }
        }

    }
}
