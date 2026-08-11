package com.rajjaviya.jetpackcomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.rememberNavController
import com.rajjaviya.jetpackcomposeui.ui.navigation.NavGraph
import com.rajjaviya.jetpackcomposeui.ui.theme.JetpackComposeUITheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeUITheme {

                val navController = rememberNavController()

                NavGraph(navController = navController)
            }
        }
    }
}
