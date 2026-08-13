package com.rajjaviya.jetpackcomposeui.ui.core

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

object Utility {
    fun formateDate(dateTime: LocalDateTime): String {
        val formater = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.getDefault())
        return dateTime.format(formater)
    }
}