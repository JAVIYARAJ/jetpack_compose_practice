package com.rajjaviya.jetpackcomposeui.ui.viewmodel

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import com.rajjaviya.jetpackcomposeui.ui.model.BondOnBoardingModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Date

class BondOnBoardingViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(BondOnBoardingModel())

    val uiState = _uiState.asStateFlow()

    fun updatePhoneNumber(phoneNumber: String) {
        _uiState.value = _uiState.value.copy(phoneNumber= phoneNumber)
    }

    fun updateName(name: String) {
        _uiState.value = _uiState.value.copy(name = name)
    }

    fun updateBOD(bod: Date) {
        _uiState.value = _uiState.value.copy(bod = bod)
    }

    fun updateProfileImage(profileImage: Uri?) {
        _uiState.value = _uiState.value.copy(profileImage = profileImage)
    }

    fun updatePostImages(postImages: List<Uri>) {
        _uiState.value = _uiState.value.copy(
            postImages = _uiState.value.postImages.toMutableList().apply {
                addAll(postImages)
            })
    }

    fun removePostImage(index: Int) {
        _uiState.value = _uiState.value.copy(
            postImages = _uiState.value.postImages.toMutableList().apply {
                removeAt(index)
            })

    }

    fun updateIntro(intro: String) {
        _uiState.value = _uiState.value.copy(
            intro = intro
        )
    }
}