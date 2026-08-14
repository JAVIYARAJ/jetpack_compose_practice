package com.rajjaviya.jetpackcomposeui.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajjaviya.jetpackcomposeui.R
import com.rajjaviya.jetpackcomposeui.ui.components.BondIconComponent
import com.rajjaviya.jetpackcomposeui.ui.core.DummyModelConstant
import com.rajjaviya.jetpackcomposeui.ui.theme.BackgroundColor

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BondDiscoverScreen() {


    Scaffold(bottomBar = {
        BottomAppBar(
            containerColor = BackgroundColor, contentPadding = PaddingValues(horizontal = 15.dp)
        ) {
            TextField(
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = BackgroundColor,
                    focusedContainerColor = BackgroundColor,
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
                    IconButton(
                        shape = CircleShape, colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color.Black
                        ), onClick = {}) {
                        Icon(
                            Icons.Filled.ArrowUpward,
                            contentDescription = "send message",
                            tint = Color.White
                        )
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
    }, topBar = {
        CenterAlignedTopAppBar(
            navigationIcon = {
                BondIconComponent(icon = Icons.Default.ArrowBackIosNew, onTap = {

                })
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = BackgroundColor
            ),
            title = {
                Text("Discover", fontSize = 23.sp, fontWeight = FontWeight.W500)
            },
        )
    }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it), color = BackgroundColor
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {

                Spacer(
                    modifier = Modifier.height(50.dp)
                )

                DiscoverTile(title = "\uD83C\uDF7D\uFE0F Best food to get right now")
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
                DiscoverTile(title = "\uD83C\uDF86 Perfect place to go out on Friday")
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
                DiscoverTile(title = "\uD83C\uDFAC TV show that I will love")

                Spacer(
                    modifier = Modifier.height(30.dp)
                )

                val messages = DummyModelConstant.listOfDiscoverMessages;

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    items(messages.size, key = { index ->
                        "message-${index}"
                    }) { index ->

                        val isApiResponse = messages[index].isAiResponse

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = if (isApiResponse) {
                                Arrangement.Start
                            } else {
                                Arrangement.End
                            }
                        ) {
                            Surface(
                                color = if (isApiResponse) {
                                    Color(0XFFebebeb)
                                } else Color.Black,
                                shape = if (isApiResponse) {
                                    RoundedCornerShape(
                                        topEnd = 15.dp,
                                        bottomStart = 15.dp,
                                        bottomEnd = 15.dp
                                    )
                                } else {
                                    RoundedCornerShape(
                                        topEnd = 15.dp,
                                        topStart = 15.dp,
                                        bottomStart = 15.dp
                                    )
                                },
                            ) {
                                Text(
                                    messages[index].message,
                                    style = MaterialTheme.typography.titleMedium,
                                    modifier = Modifier.padding(
                                        horizontal = if (isApiResponse) {
                                            15.dp
                                        } else {
                                            5.dp
                                        }, vertical = 12.dp
                                    ),
                                    color = if (isApiResponse) {
                                        Color.Black
                                    } else {
                                        Color.White
                                    },
                                    textAlign = if (isApiResponse) {
                                        TextAlign.Start
                                    } else {
                                        TextAlign.End
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DiscoverTile(title: String) {
    Surface(
        color = Color(0XFFebebeb), shape = RoundedCornerShape(30.dp)
    ) {
        Text(
            title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 12.dp)
        )
    }
}