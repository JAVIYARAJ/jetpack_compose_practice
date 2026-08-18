package com.rajjaviya.jetpackcomposeui.ui.pages

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rajjaviya.jetpackcomposeui.R
import com.rajjaviya.jetpackcomposeui.ui.components.BondCommonTopBar
import com.rajjaviya.jetpackcomposeui.ui.core.SpeechRecognizerHelper
import com.rajjaviya.jetpackcomposeui.ui.navigation.Routes
import com.rajjaviya.jetpackcomposeui.ui.theme.BackgroundColor

@Composable
fun BondUserIntroScreen(navController: NavHostController) {

    var intro by remember { mutableStateOf("") }

    // to identify like mic on or off
    var isListening by remember { mutableStateOf(false) }

    val context = LocalContext.current

    val speechRecognizerHelper = SpeechRecognizerHelper(context)


    // to ask and check audio record permission
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            if (isListening) {
                speechRecognizerHelper.stopListening()
                isListening = false
            } else {
                speechRecognizerHelper.startListening(onResult = {
                    intro = it
                    isListening = false
                }, onError = {
                    isListening = false
                })
                isListening = true
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            speechRecognizerHelper.destroy()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            topBar = {
                BondCommonTopBar(onTap = {
                    navController.popBackStack()
                }, title = {
                    Text(
                        "Introduce yourself",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.W500
                    )
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
                Spacer(
                    modifier = Modifier.height(15.dp)
                )
                Card(
                    shape = RoundedCornerShape(5.dp), colors = CardDefaults.cardColors(
                        containerColor = Color(0XFFeaeaea)
                    ), modifier = Modifier.rotate(-5f)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_user_avtar),
                        contentDescription = "avtar",
                        modifier = Modifier
                            .size(170.dp)
                            .padding(8.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }

        // FAB — above keyboard via imePadding, disabled until name is valid
        Box(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
                .padding(end = 16.dp, bottom = 26.dp, start = 16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(
                    containerColor = Color(0XFFf8f8f8)
                ), elevation = CardDefaults.cardElevation(
                    5.dp
                ), shape = RoundedCornerShape(15.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 26.dp)
                ) {
                    val fabColor by animateColorAsState(
                        targetValue = if (intro.isNotEmpty()) Color.Black else Color(0xFFCCCCCC),
                        animationSpec = tween(300),
                        label = "fabColor"
                    )

                    Image(
                        painter = painterResource(R.drawable.ic_quotes_icon),
                        contentDescription = "quotes icon"
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    BasicTextField(
                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W300,
                            fontStyle = FontStyle.Italic
                        ),
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.None
                        ),
                        value = intro,
                        onValueChange = {
                            intro = it
                        },
                        maxLines = 5,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                    )

                    Spacer(
                        modifier = Modifier.height(50.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0XFFfdfdfd), contentColor = Color.Black
                            ), contentPadding = PaddingValues(8.dp), modifier = Modifier.shadow(
                                elevation = 5.dp, shape = RoundedCornerShape(30.dp)
                            ), onClick = {
                                permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                            }) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(
                                        if (isListening) {
                                            R.drawable.ic_mic_stop_icon
                                        } else {
                                            R.drawable.ic_mic_start_icon
                                        }
                                    ),
                                    contentDescription = "voice icon",
                                    modifier = Modifier.size(30.dp)
                                )

                                Spacer(modifier = Modifier.width(5.dp))

                                Text(
                                    "Voice input",
                                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.W400),
                                    fontWeight = FontWeight.W800,
                                )
                            }
                        }

                        /*Card(
                            shape = RoundedCornerShape(30.dp), colors = CardDefaults.cardColors(
                                containerColor = Color(0XFFfdfdfd)
                            ), modifier = Modifier
                                .padding(end = 10.dp)
                                .clickable(onClick = {
                                    permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                                }), elevation = CardDefaults.cardElevation(
                                10.dp
                            )
                        ) {

                        }*/

                        Spacer(
                            modifier = Modifier.width(10.dp)
                        )

                        IconButton(
                            enabled = intro.isNotEmpty(),
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = fabColor,
                                contentColor = Color.White,
                                disabledContainerColor = fabColor,
                                disabledContentColor = Color.White,
                            ),
                            shape = CircleShape,
                            modifier = Modifier.size(55.dp),
                            onClick = {
                                navController.navigate(Routes.BondUserIntroScreen)
                            }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next"
                            )
                        }
                    }

                }
            }

        }

    }
}