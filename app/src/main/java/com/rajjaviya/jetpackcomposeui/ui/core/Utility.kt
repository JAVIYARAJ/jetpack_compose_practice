package com.rajjaviya.jetpackcomposeui.ui.core

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

object Utility {
    @RequiresApi(Build.VERSION_CODES.O)
    fun formateDate(dateTime: LocalDateTime): String {
        val formater = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.getDefault())
        return dateTime.format(formater)
    }

    fun convertMillisToDate(millis: Long): String {
        val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
        return formatter.format(Date(millis))
    }
}