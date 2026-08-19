package com.rajjaviya.jetpackcomposeui.ui.core.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// preferencesDataStore delegate MUST be a top-level property, not inside a class
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "bond_app")

class DataStoreModule(private val context: Context) {
    companion object {
        val WELCOME_SCREEN = booleanPreferencesKey("welcome_screen_visited")
    }

    val welcomeFlow: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[WELCOME_SCREEN] ?: false
    }

    suspend fun saveWelcomeVisitFlag(value: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[WELCOME_SCREEN] = value
        }
    }

}