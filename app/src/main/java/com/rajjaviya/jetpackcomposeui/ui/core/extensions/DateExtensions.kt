package com.rajjaviya.jetpackcomposeui.ui.core.extensions

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
fun Date?.toLocalDateTime(): LocalDateTime? {
    return this?.toInstant()
        ?.atZone(ZoneId.systemDefault()) // Binds the instant to the device's local timezone
        ?.toLocalDateTime()
}