package com.rajjaviya.jetpackcomposeui.ui.core.extensions

fun String?.orDefault(default: String = ""): String {
    return if (this.isNullOrBlank()) {
        default
    } else {
        this
    }
}