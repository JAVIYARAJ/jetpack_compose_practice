package com.rajjaviya.jetpackcomposeui.ui.pages

import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.rajjaviya.jetpackcomposeui.ui.components.BondCommonTopBar
import com.rajjaviya.jetpackcomposeui.ui.core.Utility
import com.rajjaviya.jetpackcomposeui.ui.core.extensions.toLocalDateTime
import com.rajjaviya.jetpackcomposeui.ui.navigation.Routes
import com.rajjaviya.jetpackcomposeui.ui.theme.BackgroundColor
import com.rajjaviya.jetpackcomposeui.ui.viewmodel.BondOnBoardingViewModel
import java.net.URI

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UserProfilePreviewScreen(
    navController: NavHostController,
    viewModel: BondOnBoardingViewModel,
) {

    val viewModelState by viewModel.uiState.collectAsStateWithLifecycle()

    val scrollState = rememberScrollState()

    var isDialogOpen by remember { mutableStateOf(false) }

    var currentImageIndex by remember { mutableIntStateOf(0) }

    var isStoryImagesDialogOpen by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {

        if (isDialogOpen) {
            ProfileImageDialog(image = viewModelState.profileImage!!, onDismiss = {
                isDialogOpen = false
            })
        }

        if (isStoryImagesDialogOpen) {
            ProfileStoryImagesDialog(images = viewModelState.postImages, onDismiss = {
                isStoryImagesDialogOpen = false
            }, currentIndex = currentImageIndex)
        }

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
                    .padding(horizontal = 25.dp)
                    .verticalScroll(scrollState),
            ) {

                // Title

                Text(
                    text = "Profile Preview",
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

                Card(
                    shape = RoundedCornerShape(10.dp), colors = CardDefaults.cardColors(
                        containerColor = Color(0XFFf3f3f4)
                    ), elevation = CardDefaults.cardElevation(
                        5.dp
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        AsyncImage(
                            model = viewModelState.profileImage,
                            contentDescription = "image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(150.dp)
                                .clip(CircleShape)
                                .clickable(onClick = {
                                    isDialogOpen = true
                                })
                        )

                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        Text(viewModelState.name, style = MaterialTheme.typography.titleMedium)

                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        Text(
                            viewModelState.phoneNumber ?: "",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        HorizontalDivider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 2.dp),
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                Icons.Default.CalendarMonth,
                                contentDescription = "cal_icon",
                                tint = Color.Gray,
                                modifier = Modifier.size(20.dp)
                            )

                            Spacer(modifier = Modifier.width(5.dp))

                            Text(
                                "Born on ${Utility.formateDate(viewModelState.bod?.toLocalDateTime())}",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Gray
                            )
                        }

                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    "Posts (${viewModelState.postImages.size})",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(20.dp))

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(
                        key = { "key-${it}" }, count = viewModelState.postImages.size
                    ) { index ->
                        AsyncImage(
                            model = viewModelState.postImages[index],
                            contentDescription = "image-${index}",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .clickable(onClick = {
                                    isStoryImagesDialogOpen = true
                                    currentImageIndex = index
                                }),
                            contentScale = ContentScale.Crop,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    "Intro",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    viewModelState.intro,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.Start),
                    maxLines = 15,
                )

                Spacer(modifier = Modifier.height(150.dp))
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
                targetValue = if (viewModelState.postImages.isNotEmpty()) Color.Black else Color(
                    0xFFCCCCCC
                ), animationSpec = tween(300), label = "fabColor"
            )

            Button(
                shape = RoundedCornerShape(30.dp), colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                ), onClick = {

                }) {
                Row(
                    modifier = Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Continue", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next"
                    )
                }
            }
        }

    }
}

@Composable
fun ProfileImageDialog(image: Uri, onDismiss: () -> Unit = {}) {
    Dialog(
        onDismissRequest = {
            onDismiss()
        }, properties = DialogProperties(
            dismissOnBackPress = true, dismissOnClickOutside = true, usePlatformDefaultWidth = true
        )
    ) {
        AsyncImage(
            model = image,
            contentDescription = "full_image",
            modifier = Modifier
                .size(250.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileStoryImagesDialog(
    images: List<Uri>,
    currentIndex: Int = 0,
    onDismiss: () -> Unit = {}
) {
    if (images.isEmpty()) return

    val pagerState = rememberPagerState(
        initialPage = currentIndex,
        pageCount = { images.size }
    )

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Black)
            ) {

                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    pageSpacing = 8.dp
                ) { page ->

                    AsyncImage(
                        model = images[page],
                        contentDescription = "Profile image ${page + 1}",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Fit
                    )
                }

                // Page indicator
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(images.size) { index ->

                        val isSelected = pagerState.currentPage == index

                        Box(
                            modifier = Modifier
                                .padding(horizontal = 3.dp)
                                .size(
                                    width = if (isSelected) 20.dp else 7.dp,
                                    height = 7.dp
                                )
                                .clip(CircleShape)
                                .background(
                                    if (isSelected) {
                                        Color.White
                                    } else {
                                        Color.White.copy(alpha = 0.4f)
                                    }
                                )
                        )
                    }
                }
            }

            // Close button
            IconButton(
                onClick = onDismiss,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .background(
                        Color.Black.copy(alpha = 0.6f),
                        CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color.White
                )
            }
        }
    }
}
