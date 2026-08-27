package com.rajjaviya.jetpackcomposeui.ui.pages

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajjaviya.jetpackcomposeui.R
import com.rajjaviya.jetpackcomposeui.ui.components.BondCommonTopBar
import com.rajjaviya.jetpackcomposeui.ui.core.Utility
import com.rajjaviya.jetpackcomposeui.ui.core.constants.DummyModelConstant
import com.rajjaviya.jetpackcomposeui.ui.model.BondStoryModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BondScreen() {
    val screenBackground = Color(0xFFF6F6F6)

    Scaffold(bottomBar = {
        BottomAppBar(
            containerColor = screenBackground,
            contentPadding = PaddingValues(horizontal = 15.dp)
        ) {
            TextField(
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = screenBackground,
                    focusedContainerColor = screenBackground,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text("Discover using your memories", fontSize = 15.sp)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 6.dp, shape = RoundedCornerShape(30.dp)),
                value = "",
                onValueChange = {

                },
                trailingIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "send message")
                    }
                },
                leadingIcon = {
                    Image(
                        painter = painterResource(R.drawable.gemini_icon),
                        contentDescription = "leading icon",
                        modifier = Modifier.size(25.dp)
                    )
                })
        }
    }, containerColor = Color(0XFFf6f6f6), modifier = Modifier.fillMaxSize(), topBar = {
        BondCommonTopBar(
            navigationVisible = false,
            actions = {
            IconButton(
                onClick = {

                }) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add action",
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp),
                )
            }
        })
    }) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(), color = screenBackground
        ) {

            val stories = DummyModelConstant.listOfStory.filter { it.images.isNotEmpty() }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(count = 3),
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        count = stories.size + 1, key = { index ->
                            if (index == 0) {
                                "add_story"
                            } else {
                                "story_${stories[index - 1].id}"
                            }
                        }) { index ->
                        if (index == 0) {
                            AddStoryItem {

                            }
                        } else {
                            BondCard(model = stories[index - 1])
                        }
                    }
                }
            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BondCard(model: BondStoryModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .height((100 + 5).dp)
                .width((100 + 5).dp)
        ) {

            val isOnlyOneImage = model.images.size == 1

            Box {
                if (model.images.size > 1) {
                    Card(
                        shape = RoundedCornerShape(15.dp),
                        border = BorderStroke(3.dp, color = Color.White),
                        modifier = Modifier
                            .align(Alignment.Center)
                            .rotate(16f)
                    ) {
                        Image(
                            painter = painterResource(model.images[1]),
                            contentDescription = "image",
                            modifier = Modifier
                                .height(100.dp)
                                .width(80.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                Card(
                    shape = RoundedCornerShape(15.dp),
                    border = BorderStroke(3.dp, color = Color.White),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .rotate(
                            if (isOnlyOneImage) {
                                0f
                            } else -2f
                        )
                ) {
                    Image(
                        painter = painterResource(model.images[0]),
                        contentDescription = "image",
                        modifier = Modifier
                            .height(100.dp)
                            .width(80.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                UserAvtar(modifier = Modifier.align(Alignment.BottomEnd))
            }
        }

        Spacer(
            Modifier.height(8.dp)
        )

        Text(
            model.name,
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
            fontWeight = FontWeight.W700
        )

        Spacer(
            Modifier.height(5.dp)
        )

        Text(
            Utility.formateDate(model.date),
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
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
            painter = painterResource(R.drawable.ic_user_avtar),
            contentDescription = "user_image",
            modifier = Modifier.size(30.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun AddStoryItem(
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .height((150 + 5).dp)
            .width((150 + 5).dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Story circle
            Box(
                modifier = Modifier
                    .size(65.dp)
                    .shadow(
                        elevation = 6.dp, shape = CircleShape
                    )
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable { onClick() },
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Story",
                    tint = Color.Gray,
                    modifier = Modifier.size(38.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Label
            Text(
                text = "Add Story",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                fontWeight = FontWeight.W700
            )
        }
    }
}