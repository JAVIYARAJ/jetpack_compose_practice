package com.rajjaviya.jetpackcomposeui.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rajjaviya.jetpackcomposeui.ui.navigation.Routes
import com.rajjaviya.jetpackcomposeui.ui.theme.BackgroundColor

@Composable
fun BondOnBoardingNameScreen(
    navController: NavHostController,
) {
    var name by rememberSaveable { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    // Auto-open keyboard when screen loads
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    // Animate underline color: black when focused, light grey when not
    val underlineColor by animateColorAsState(
        targetValue = if (isFocused) Color.Black else Color(0xFFDDDDDD),
        animationSpec = tween(durationMillis = 300),
        label = "underlineColor"
    )

    // Animate underline thickness
    val underlineThickness by animateDpAsState(
        targetValue = if (isFocused) 2.dp else 1.dp,
        animationSpec = tween(durationMillis = 300),
        label = "underlineThickness"
    )

    val isNameValid = name.trim().length >= 2

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
                Spacer(Modifier.fillMaxHeight(0.2f))

                // Title
                Text(
                    text = "What's your name?",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.W400,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF1A1A1A)
                )

                Spacer(Modifier.height(6.dp))

                // Subtitle
                Text(
                    text = "This is how you'll appear to others",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.W300,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF888888)
                )

                Spacer(Modifier.height(40.dp))

                // ── Custom underline text field ─────────────────────────────
                BasicTextField(
                    value = name,
                    onValueChange = { if (it.length <= 40) name = it },
                    singleLine = true,
                    cursorBrush = SolidColor(Color.Black),
                    textStyle = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.W400,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF1A1A1A),
                        letterSpacing = 0.5.sp,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done,
                        capitalization = KeyboardCapitalization.Words,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester)
                        .onFocusChanged { isFocused = it.isFocused },
                    decorationBox = { innerTextField ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                            ) {
                                // Placeholder text
                                if (name.isEmpty()) {
                                    Text(
                                        text = "Your name",
                                        style = TextStyle(
                                            fontSize = 28.sp,
                                            fontWeight = FontWeight.W300,
                                            textAlign = TextAlign.Center,
                                            color = Color(0xFFCCCCCC),
                                        )
                                    )
                                }
                                innerTextField()
                            }

                            // Animated underline
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.7f)
                                    .height(underlineThickness)
                                    .background(underlineColor)
                            )
                        }
                    }
                )
                // ────────────────────────────────────────────────────────────

                Spacer(Modifier.height(16.dp))

                // Character counter — subtle, appears only when typing
                AnimatedVisibility(
                    visible = name.isNotEmpty(),
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut()
                ) {
                    Text(
                        text = "${name.trim().length} / 40",
                        fontSize = 12.sp,
                        color = Color(0xFFAAAAAA),
                        textAlign = TextAlign.Center,
                    )
                }

                Spacer(Modifier.height(12.dp))

                // Validation hint — slides in when name is too short
                AnimatedVisibility(
                    visible = name.isNotEmpty() && !isNameValid,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Please enter at least 2 characters",
                            fontSize = 12.sp,
                            color = Color(0xFFE53935),
                            textAlign = TextAlign.Center,
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
                targetValue = if (isNameValid) Color.Black else Color(0xFFCCCCCC),
                animationSpec = tween(300),
                label = "fabColor"
            )
            IconButton(
                enabled = isNameValid,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = fabColor,
                    contentColor = Color.White,
                    disabledContainerColor = fabColor,
                    disabledContentColor = Color.White,
                ),
                shape = CircleShape,
                modifier = Modifier.size(55.dp),
                onClick = {
                    if(isNameValid){
                        navController.navigate(Routes.BondOnBODScreen)
                    }
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
