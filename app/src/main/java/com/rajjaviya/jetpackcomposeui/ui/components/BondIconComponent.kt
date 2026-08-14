package com.rajjaviya.jetpackcomposeui.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun BondIconComponent(icon: ImageVector, onTap: () -> Unit) {
    IconButton(
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.Gray.copy(alpha = 0.2f)
        ), modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .size(35.dp), onClick = onTap
    ) {
        Icon(icon, contentDescription = "back icon")
    }
}