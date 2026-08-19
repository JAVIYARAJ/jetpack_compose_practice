package com.rajjaviya.jetpackcomposeui.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.rajjaviya.jetpackcomposeui.ui.core.datastore.DataStoreModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SplashScreenViewModel(private val dataStoreModule: DataStoreModule) : ViewModel() {
    private val _splashUiState = MutableStateFlow<Boolean>(false)
    val splashUiState = _splashUiState.asStateFlow()

    suspend fun getWelcomeScreenFlag() {
        dataStoreModule.welcomeFlow.collect {
            _splashUiState.value = it
        }
    }

}