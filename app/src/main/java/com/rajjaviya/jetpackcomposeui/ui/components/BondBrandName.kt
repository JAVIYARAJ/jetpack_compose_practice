package com.rajjaviya.jetpackcomposeui.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.rajjaviya.jetpackcomposeui.ui.theme.RegularRubikFonts

@Composable
fun BondBrandName() {
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            "b",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontFamily = RegularRubikFonts,
                fontSize = 100.sp
            ),
            color = Color.Black,
        )
        Text(
            "on",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontFamily = RegularRubikFonts,
                fontSize = 85.sp
            ),
            color = Color.Black,
        )
        Text(
            "d",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontFamily = RegularRubikFonts,
                fontSize = 100.sp
            ),
            color = Color.Black,
        )
    }
}