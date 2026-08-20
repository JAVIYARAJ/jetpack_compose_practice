package com.rajjaviya.jetpackcomposeui.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajjaviya.jetpackcomposeui.ui.theme.OsWaldBold
import com.rajjaviya.jetpackcomposeui.ui.theme.OsWaldMedium
import com.rajjaviya.jetpackcomposeui.ui.theme.OsWaldRegular
import com.rajjaviya.jetpackcomposeui.ui.theme.OsWaldSemiBold
import com.rajjaviya.jetpackcomposeui.ui.theme.TravelAccent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelLoginScreen(
    onBackClick: () -> Unit = {},
    onSignInClick: (email: String, password: String) -> Unit = { _, _ -> },
    onCreateAccountClick: () -> Unit = {}
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var contentVisible by remember { mutableStateOf(false) }


    LaunchedEffect(Unit) { contentVisible = true }

    Box(modifier = Modifier.fillMaxSize()) {

        // ── Scrollable content ────────────────────────────────────────────────
        Scaffold(
            backgroundColor = Color.White, topBar = {
                CenterAlignedTopAppBar(
                    modifier = Modifier.shadow(elevation = 3.dp),
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Back",
                                modifier = Modifier.size(25.dp)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White
                    ),
                    title = {
                        Text(
                            text = "Login",
                            fontFamily = OsWaldMedium,
                            fontSize = 20.sp,
                            letterSpacing = 0.5.sp
                        )
                    })
            }) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .windowInsetsPadding(WindowInsets.safeDrawing)
                    .padding(innerPadding)
            ) {

                // ── Headline ──────────────────────────────────────────────────────
                Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                    Text(
                        text = "Welcome Back",
                        fontFamily = OsWaldBold,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 40.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Sign in to Kinetic Travel to continue your journey.",
                        fontFamily = OsWaldRegular,
                        fontSize = 15.sp,
                        lineHeight = 22.sp
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                // ── Glassmorphism Card ────────────────────────────────────────────
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {

                    // ── Email field label ──────────────────────────────────
                    Text(
                        text = "EMAIL ADDRESS",
                        fontFamily = OsWaldMedium,
                        fontSize = 11.sp,
                        letterSpacing = 1.2.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    // ── Email TextField ────────────────────────────────────
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        placeholder = {
                            Text(
                                "name@company.com",
                                fontFamily = OsWaldRegular,
                                fontSize = 14.sp,
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        singleLine = true,
                        shape = RoundedCornerShape(5.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            cursorColor = TravelAccent,
                            focusedBorderColor = TravelAccent,
                            unfocusedBorderColor = Color.Black,
                            unfocusedTextColor = Color.Black,
                            focusedLeadingIconColor = TravelAccent,
                            unfocusedLeadingIconColor = Color.Black
                        ),
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // ── Password label row ─────────────────────────────────
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "PASSWORD",
                            fontFamily = OsWaldMedium,
                            fontSize = 11.sp,
                            letterSpacing = 1.2.sp
                        )/*TextButton(
                            contentPadding = PaddingValues.Zero,
                            onClick = {},
                        ) {
                            Text(
                                text = "Forgot?",
                                fontFamily = OsWaldMedium,
                                fontSize = 13.sp,
                                color = Color.Black
                            )
                        }*/
                    }

                    // ── Password TextField ─────────────────────────────────
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text(
                                "••••••••",
                                fontFamily = OsWaldRegular,
                                fontSize = 14.sp,
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    imageVector = if (passwordVisible) Icons.Default.Visibility
                                    else Icons.Default.VisibilityOff,
                                    contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        },
                        visualTransformation = if (passwordVisible) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        singleLine = true,
                        shape = RoundedCornerShape(5.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            cursorColor = TravelAccent,
                            focusedBorderColor = TravelAccent,
                            unfocusedBorderColor = Color.Black,
                            unfocusedTextColor = Color.Black,
                            focusedLeadingIconColor = TravelAccent,
                            unfocusedLeadingIconColor = Color.Black,
                            focusedTrailingIconColor = TravelAccent,
                            unfocusedTrailingIconColor = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.height(28.dp))

                    // ── Sign In Button ─────────────────────────────────────
                    Button(
                        onClick = { onSignInClick(email, password) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                        ),
                        contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(TravelAccent, Color(0xFF1A5FAA))
                                    ), shape = RoundedCornerShape(14.dp)
                                ), contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Sign In",
                                    fontFamily = OsWaldSemiBold,
                                    fontSize = 18.sp,
                                    letterSpacing = 0.5.sp,
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }

                /*Spacer(modifier = Modifier.height(16.dp))

                // ── Divider "or continue with" ────────────────────────────────────
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(modifier = Modifier.weight(1f))
                    Text(
                        text = "  or continue with  ",
                        fontFamily = OsWaldRegular,
                        fontSize = 13.sp,
                    )
                    HorizontalDivider(modifier = Modifier.weight(1f))
                }*/

                Spacer(modifier = Modifier.height(16.dp))

                // ── Create Account CTA ────────────────────────────────────────────
                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    val annotated = buildAnnotatedString {
                        withStyle(
                            SpanStyle(
                                fontFamily = OsWaldRegular, fontSize = 14.sp, color = Color.Black
                            )
                        ) {
                            append("Don't have an account?  ")
                        }
                        withStyle(
                            SpanStyle(
                                fontFamily = OsWaldMedium, fontSize = 15.sp, color = Color.Black
                            )
                        ) {
                            append("Sign Up")
                        }
                    }
                    TextButton(onClick = onCreateAccountClick) {
                        Text(text = annotated)
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }
}
