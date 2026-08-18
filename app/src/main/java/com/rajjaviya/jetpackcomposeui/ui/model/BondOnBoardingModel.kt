package com.rajjaviya.jetpackcomposeui.ui.model

import android.net.Uri
import java.time.LocalDateTime

data class BondOnBoardingModel(
    val phoneNumber: String? = null,
    val name: String? = null,
    val bod: LocalDateTime? = null,
    val profileImage: Uri? = null,
    val postImages: List<Uri>? = null,
    val intro: String? = null
)