package com.pamlanjut.evolvance20.data.repository.authentication

import com.pamlanjut.evolvance20.data.local.AuthPreference
import com.pamlanjut.evolvance20.data.remote.api.AuthApi
import com.pamlanjut.evolvance20.data.remote.api.LoginRequest
import com.pamlanjut.evolvance20.domain.model.AuthTokenModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val preference: AuthPreference
) : AuthRepository {
    override suspend fun login(email: String, password: String): AuthTokenModel {
        val response = api.login(
            LoginRequest(email, password)
        )
        return AuthTokenModel(response.accessToken)
    }

    override suspend fun saveToken(token: String) {
        preference.saveAccessToken(token)
    }
}