package com.rajjaviya.jetpackcomposeui.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rajjaviya.jetpackcomposeui.ui.core.datastore.DataStoreModule

class WelcomeScreenViewModelFactory(
    private val dataStoreModule: DataStoreModule
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WelcomeScreenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return WelcomeScreenViewModel(dataStoreModule) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}