package com.rajjaviya.jetpackcomposeui.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rajjaviya.jetpackcomposeui.ui.core.datastore.DataStoreModule

@Suppress("UNCHECKED_CAST")
class SplashViewModelFactory(private val dataStoreModule: DataStoreModule) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashScreenViewModel::class.java)) {
            return SplashScreenViewModel(dataStoreModule = dataStoreModule) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}