package com.rajjaviya.jetpackcomposeui.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.joelkanyi.jcomposecountrycodepicker.component.KomposeCountryCodePicker
import com.joelkanyi.jcomposecountrycodepicker.component.rememberKomposeCountryCodePickerState

@Composable
fun BondCountryPickerBasicText(
    onPhoneNumberReady: (fullNumber: String) -> Unit = {}
) {
    var phoneNumber by rememberSaveable { mutableStateOf("") }

    val state = rememberKomposeCountryCodePickerState(
        defaultCountryCode = "IN",
        showCountryCode = true,
        showCountryFlag = true,
    )

    // Wrap with a custom colorScheme to control the country-list dialog background.
    // The dialog uses colorScheme.surface as its container color.
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(
            surface = Color.White,               // ← country list dialog background
            onSurface = Color(0xFF1A1A2E),       // ← country name / dial-code text color
            surfaceVariant = Color(0xFFF5F5F5),  // ← search bar background
        )
    ) {
        KomposeCountryCodePicker(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            shape = RoundedCornerShape(15.dp),
            text = phoneNumber,
            onValueChange = {
                phoneNumber = it
                // Emit country code + digits as the full phone number
                onPhoneNumberReady("${state.selectedCountry.phoneNoCode}$it")
            },
            placeholder = { Text(text = "Mobile Number") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black.copy(alpha = 0.5f),
                unfocusedBorderColor = Color(0xFFDDDDDD),
            ),
            state = state,
        )
    }
}