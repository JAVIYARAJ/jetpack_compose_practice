package com.rajjaviya.jetpackcomposeui.ui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajjaviya.jetpackcomposeui.R
import com.rajjaviya.jetpackcomposeui.ui.theme.PrimaryColor
import com.rajjaviya.jetpackcomposeui.ui.theme.RegularRubikFonts

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BondScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.shadow(elevation = 3.dp),
                title = {
                    Text(
                        "Bond",
                        style = MaterialTheme.typography.headlineLarge.copy(fontFamily = RegularRubikFonts, fontSize = 30.sp),
                    )
                },
                actions = {
                    IconButton(
                        onClick = {

                        }) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "Add action",
                            tint = Color.Black,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {

                BondCard(imageResource = R.drawable.image_01)

                Spacer(
                    Modifier.height(20.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    BondCard(imageResource = R.drawable.image_01)
                    BondCard(imageResource = R.drawable.image_03)
                }

                Spacer(
                    Modifier.height(20.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    BondCard(imageResource = R.drawable.image_01)
                    BondCard(imageResource = R.drawable.image_02)
                    BondCard(imageResource = R.drawable.image_03)
                }
            }
        }
    }
}

@Composable
fun BondCard(imageResource: Int) {
    Surface(
        modifier = Modifier
            .height((150 + 5).dp)
            .width((130 + 5).dp)
            .background(color = Color.Blue),
    ) {
        Box {
            Card(
                shape = RoundedCornerShape(15.dp),
                border = BorderStroke(3.dp, color = Color.White),
                modifier = Modifier
                    .align(Alignment.Center)
                    .rotate(12f)
            ) {
                Image(
                    painter = painterResource(R.drawable.image_03),
                    contentDescription = "image",
                    modifier = Modifier
                        .height(125.dp)
                        .width(120.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Card(
                shape = RoundedCornerShape(15.dp),
                border = BorderStroke(3.dp, color = Color.White),
                modifier = Modifier
                    .align(Alignment.Center)
                    .rotate(-2f)
            ) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = "image",
                    modifier = Modifier
                        .height(150.dp)
                        .width(120.dp),
                    contentScale = ContentScale.Crop
                )
            }
            UserAvtar(modifier = Modifier.align(Alignment.BottomEnd))
        }
    }
}

@Preview
@Composable
fun UserAvtar(modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(100.dp),
        border = BorderStroke(3.dp, color = Color.White),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(R.drawable.image_01),
            contentDescription = "user_image",
            modifier = Modifier.size(30.dp),
            contentScale = ContentScale.Crop
        )
    }
}

