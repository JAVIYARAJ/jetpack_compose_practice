package com.rajjaviya.jetpackcomposeui.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.ChangeHistory
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Money
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajjaviya.jetpackcomposeui.R


@Preview
@Composable
fun PayPalBalanceActiveCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("PayPal Balance", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color(0XFF505050))
                    Image(
                        modifier = Modifier.size(45.dp),
                        painter = painterResource(R.drawable.paypal_icon), contentDescription = "PayPal description", contentScale = ContentScale.Crop,)
                }

                Spacer(
                    Modifier.height(5.dp)
                )

                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color(0XFFfff5e2),
                ) {
                    Text(
                        "Activate PayPal Debit card",
                        fontSize = 12.sp,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp),
                        fontWeight = FontWeight.W500,
                        color = Color(0XFF795b15)
                    )
                }

                Spacer(
                    Modifier.height(6.dp)
                )

                Text(
                    "$0.85",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    lineHeight = 30.sp
                )

                Spacer(
                    Modifier.height(3.dp)
                )

                Text(
                    "Available balance",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )

                Spacer(
                    Modifier.height(15.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {

                    CardActionItem(title = "Add Money", icon = Icons.Outlined.Money)

                    CardActionItem(title = "Transfer", icon = Icons.Outlined.ChangeHistory)

                    CardActionItem(title = "Account info", icon = Icons.Outlined.Info)
                }
            }

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color =  Color(0XFF61cdff),
                onClick = {

                }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                ) {
                    Surface(
                        color = Color(0XFF0066f3),
                        modifier = Modifier.size(55.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Icon(imageVector = Icons.Default.AccountBalanceWallet, contentDescription = "hey", tint = Color.White, modifier = Modifier.padding(10.dp))
                    }

                    Spacer(
                        modifier = Modifier.width(10.dp)
                    )

                    Text(
                        "Add your PayPal Debit Card to your favorite stores for a faster checkout",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                        modifier = Modifier.weight(1f)
                    )

                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "back_icon", tint = Color.Black,)
                }
            }
        }

    }
}


@Composable
fun CardActionItem(title: String,icon: ImageVector) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier.size(50.dp),
            RoundedCornerShape(50.dp),
            color = Color(0XFFd0cdd0).copy(alpha = 0.4f)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = Color.Black.copy(alpha = 0.8f),
                modifier = Modifier.size(25.dp).padding(12.dp),
            )
        }

        Spacer(
            modifier = Modifier.height(5.dp)
        )

        Text(
            title,
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            color = Color.Black,
        )
    }
}