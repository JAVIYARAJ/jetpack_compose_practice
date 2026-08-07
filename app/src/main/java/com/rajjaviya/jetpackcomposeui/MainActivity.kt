package com.rajjaviya.jetpackcomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rajjaviya.jetpackcomposeui.ui.components.PayPalBalanceActiveCard
import com.rajjaviya.jetpackcomposeui.ui.components.PaypalBalanceCard
import com.rajjaviya.jetpackcomposeui.ui.theme.JetpackComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeUITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaypalBalanceCardMainPreview() {
    JetpackComposeUITheme {
        Box(
            modifier = Modifier
                .background(Color(0xFFF2F4F8))
                .padding(16.dp)
        ) {
            PaypalBalanceCard()
        }
    }
}