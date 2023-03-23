package com.example.emrekizil_usgstajyerchallenge.data.source.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val dataStore:DataStore<Preferences>
) :LocalDataSource {
    private object PreferencesKeys{
        val isFirstOpenState = booleanPreferencesKey("isFirstOpen")
    }

    override fun isAppFirstOpen(): Flow<Boolean> =
        dataStore.data
            .catch {
                emit(emptyPreferences())
            }
            .map {preference->
                preference[PreferencesKeys.isFirstOpenState] ?: false
            }

    override suspend fun saveAppFirstOpen(isFirstOpen: Boolean) {
        dataStore.edit {preference->
            preference[PreferencesKeys.isFirstOpenState] = isFirstOpen
        }

    }
}