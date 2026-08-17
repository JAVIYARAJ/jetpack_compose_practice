package com.rajjaviya.jetpackcomposeui.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rajjaviya.jetpackcomposeui.R
import com.rajjaviya.jetpackcomposeui.ui.theme.BackgroundColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BondCommonTopBar(
    actions: @Composable RowScope.() -> Unit = {},
    navigationVisible: Boolean = true,
    onTap: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            if (navigationVisible) {
                BondIconComponent(icon = Icons.Default.ArrowBackIosNew, onTap = {
                    onTap()
                })
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BackgroundColor
        ), title = {
            Image(
                painter = painterResource(R.drawable.bond_app_icon),
                contentDescription = "app bar icon",
                modifier = Modifier.size(100.dp)
            )
        }, actions = actions
    )
}