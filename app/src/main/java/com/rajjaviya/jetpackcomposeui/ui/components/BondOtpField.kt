package com.rajjaviya.jetpackcomposeui.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BondOtpField(
    otp: String,
    onOtpChange: (String) -> Unit,
    length: Int = 6
) {
    BasicTextField(
        value = otp,
        onValueChange = { value ->
            val digitsOnly = value.filter { it.isDigit() }

            if (digitsOnly.length <= length) {
                onOtpChange(digitsOnly)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    ) { innerTextField ->

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            repeat(length) { index ->

                val char = otp.getOrNull(index)?.toString() ?: ""

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp)
                        .border(
                            width = 1.dp,
                            color = if (index == otp.length) {
                                Color.Black
                            } else {
                                Color.LightGray
                            },
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = char,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // Keep the actual TextField active.
        Box(
            modifier = Modifier.size(0.dp)
        ) {
            innerTextField()
        }
    }
}