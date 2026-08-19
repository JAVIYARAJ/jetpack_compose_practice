package com.rajjaviya.jetpackcomposeui.ui.model

import android.net.Uri
import java.util.Date

data class BondOnBoardingModel(
    val phoneNumber: String? = null,
    val name: String = "",
    val bod: Date? = null,
    val profileImage: Uri? = null,
    val postImages: List<Uri> = emptyList(),
    val intro: String = ""
)