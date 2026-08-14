package com.rajjaviya.jetpackcomposeui.ui.pages

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowOutward
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowOutward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun BondDiscoverResultScreen(modifier: Modifier = Modifier) {
    Scaffold(
        containerColor = BackgroundColor,
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .padding(bottom = 20.dp)
            ) {
                Row{
                    Surface(
                        color = Color(0XFFfdfdfd),
                        modifier = Modifier
                            .shadow(
                                elevation = 4.dp,
                                shape = RoundedCornerShape(30.dp),
                            )
                            .weight(1f)
                    ) {
                        Text(
                            "Finalize",
                            modifier = Modifier.padding(12.dp),
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    }

                    Spacer(Modifier.width(10.dp))

                    Surface(
                        color = Color.Black,
                        modifier = Modifier
                            .shadow(
                                elevation = 4.dp,
                                shape = RoundedCornerShape(30.dp),
                            )
                            .weight(1f)
                    ) {
                        Text(
                            "Regenerate",
                            modifier = Modifier.padding(12.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }

                }
            }
        },
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    BondIconComponent(icon = Icons.Default.ArrowBackIosNew, onTap = {

                    })
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundColor
                ), title = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(top = 5.dp)
                    ) {
                        Card(
                            shape = RoundedCornerShape(100.dp), modifier = modifier
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_user_avtar),
                                contentDescription = "user_image",
                                modifier = Modifier.size(40.dp),
                                contentScale = ContentScale.Crop
                            )
                        }

                        Spacer(
                            Modifier.height(5.dp)
                        )

                        Text(
                            "Best nature place in India",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W700
                        )

                    }
                }, actions = {
                    BondIconComponent(icon = Icons.Default.Share, onTap = {

                    })
                })
        },
    ) { it ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 15.dp)
        ) {
            val images = DummyModelConstant.listOfTravelImages
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0XFFfdfdfd)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                ),
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
                ) {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(15.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(images.size, key = { index -> "item-${index}" }) {
                            Image(
                                painter = painterResource(images[it]),
                                contentDescription = "image-${it}",
                                modifier = modifier
                                    .width(200.dp)
                                    .height(150.dp)
                                    .clip(RoundedCornerShape(20.dp))
                            )
                        }
                    }

                    Spacer(
                        Modifier.height(20.dp)
                    )

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            "Chicham Bridge - Asia's highest suspension bridge",
                            style = MaterialTheme.typography.headlineSmall,
                        )
                        Icon(Icons.Outlined.ArrowOutward, contentDescription = "go_icon")
                    }

                    Spacer(
                        Modifier.height(5.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    "Travel Spot",
                                    style = MaterialTheme.typography.titleSmall,
                                    color = Color.Gray,
                                )

                                Spacer(
                                    Modifier.width(8.dp)
                                )

                                Box(
                                    modifier = Modifier
                                        .size(3.dp)
                                        .clip(CircleShape)
                                        .background(Color.Gray)
                                )

                                Spacer(
                                    Modifier.width(8.dp)
                                )

                                Icon(
                                    Icons.Filled.Star,
                                    contentDescription = "star",
                                    tint = Color(0XFF4fb2f0)
                                )

                                Text(
                                    "4.7",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.Gray,
                                )

                            }

                            Spacer(
                                Modifier.height(5.dp)
                            )

                            Text(
                                "Spiti Valley of Himachal Pradesh, India.",
                                style = MaterialTheme.typography.titleSmall,
                                color = Color.Gray,
                                maxLines = 3
                            )
                        }
                        Image(
                            painter = painterResource(R.drawable.ic_google_map),
                            contentDescription = "map_icon",
                            modifier = Modifier.size(45.dp)
                        )
                    }

                    Spacer(
                        Modifier.height(5.dp)
                    )

                    HorizontalDivider(
                        Modifier.height(1.dp),
                    )

                    Spacer(
                        Modifier.height(10.dp)
                    )

                    Text(
                        "Chicham Bridge is Asia's highest suspension bridge, sitting at an altitude of 13,596 feet (4,145 meters) above sea level in the Spiti Valley of Himachal Pradesh, India. Completed in 2017, it spans a deep gorge over the Samba Lamba Nallah to connect the remote villages of Chicham and Kibber.",
                        style = MaterialTheme.typography.bodyMedium
                    )


                    Spacer(
                        Modifier.height(10.dp)
                    )

                    Surface(
                        shape = RoundedCornerShape(20.dp), color = Color(0XFFf3f3f3)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(7.dp)
                        ) {
                            Text(
                                "No related memories available",
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Spacer(modifier = Modifier.width(5.dp))

                            Icon(
                                Icons.Default.ArrowOutward,
                                contentDescription = "go icon",
                                Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

