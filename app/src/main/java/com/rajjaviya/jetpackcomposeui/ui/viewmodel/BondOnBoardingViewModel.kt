package com.rajjaviya.jetpackcomposeui.ui.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.rajjaviya.jetpackcomposeui.ui.model.BondOnBoardingModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDateTime

class BondOnBoardingViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(BondOnBoardingModel())

    val uiState = _uiState.asStateFlow()

    fun updatePhoneNumber(phoneNumber: String) {
        _uiState.update { it.copy(phoneNumber = phoneNumber) }
    }

    fun updateName(name: String) {
        _uiState.value = _uiState.value.copy(name = name)
    }

    fun updateBOD(bod: LocalDateTime) {
        _uiState.value = _uiState.value.copy(bod = bod)
    }

    fun updateProfileImage(profileImage: Uri) {
        _uiState.value = _uiState.value.copy(profileImage = profileImage)
    }

    fun updatePostImages(postImages: List<Uri>) {
        _uiState.value = _uiState.value.copy(postImages = postImages)
    }
}