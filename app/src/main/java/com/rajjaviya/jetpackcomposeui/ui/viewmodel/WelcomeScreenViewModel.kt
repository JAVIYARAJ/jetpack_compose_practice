package com.rajjaviya.jetpackcomposeui.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajjaviya.jetpackcomposeui.ui.core.datastore.DataStoreModule
import kotlinx.coroutines.launch

class WelcomeScreenViewModel(private val dataStoreModule: DataStoreModule) : ViewModel() {

    fun saveVisitFlag() {
        viewModelScope.launch {
            dataStoreModule.saveWelcomeVisitFlag(true)
        }
    }
}