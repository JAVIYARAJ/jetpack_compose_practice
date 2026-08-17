package com.rajjaviya.jetpackcomposeui.ui.pages
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rajjaviya.jetpackcomposeui.ui.components.BondCommonTopBar
import com.rajjaviya.jetpackcomposeui.ui.components.BondCountryPickerBasicText
import com.rajjaviya.jetpackcomposeui.ui.navigation.Routes
import com.rajjaviya.jetpackcomposeui.ui.theme.BackgroundColor

@Composable
fun BondRegisterScreen(navController: NavHostController) {
    // Holds the latest full phone number (country code + digits) from the picker
    var fullPhoneNumber by remember { mutableStateOf("") }


    Box(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            topBar = {
                BondCommonTopBar()
            },
            containerColor = BackgroundColor
        ) { innerPadding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
            ) {
                Spacer(
                    Modifier.fillMaxHeight(0.2f)
                )

                Text("Enter your phone number", modifier = Modifier.padding(horizontal = 20.dp), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.W200, fontSize = 18.sp)

                Spacer(
                    modifier = Modifier.height(25.dp)
                )

                BondCountryPickerBasicText(
                    onPhoneNumberReady = { fullPhoneNumber = it }
                )
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
            IconButton(
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                shape = CircleShape,
                modifier = Modifier.size(55.dp),
                onClick = {
                    navController.navigate(
                        Routes.BondOtpVerificationScreen(phoneNumber = fullPhoneNumber)
                    )
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