package com.rajjaviya.jetpackcomposeui.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rajjaviya.jetpackcomposeui.ui.components.PayPalBalanceActiveCard
import com.rajjaviya.jetpackcomposeui.ui.components.PaypalBalanceCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("Jetpack compose ui")
                            }
                        )
                    },
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFF2F4F8))
                            .padding(innerPadding)
                            .padding(16.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column {
                            PaypalBalanceCard()
                            Spacer(
                                Modifier.height(20.dp)
                            )
                            PayPalBalanceActiveCard()
                        }
                    }
                }
}