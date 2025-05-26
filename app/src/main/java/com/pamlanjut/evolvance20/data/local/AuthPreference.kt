package com.pamlanjut.evolvance20.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthPreference @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        private val ACCESS_TOKEN = stringPreferencesKey("access_token")
    }

    suspend fun saveAccessToken(
        token: String
    ) {
        dataStore.edit {
            it[ACCESS_TOKEN] = token
        }
    }

    fun getAccessToken(): Flow<String?> {
        return dataStore.data.map {
            it[ACCESS_TOKEN]
        }
    }
}