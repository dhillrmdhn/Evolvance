package com.pamlanjut.evolvance20.data.repository.authentication

import com.pamlanjut.evolvance20.data.remote.api.RegisterResponse
import com.pamlanjut.evolvance20.domain.model.AuthTokenModel
import com.pamlanjut.evolvance20.utils.Result

interface AuthRepository {
    suspend fun login(
        email: String,
        password: String
    ): AuthTokenModel

    suspend fun saveToken(
        token: String
    )

    suspend fun getToken(): String?

    suspend fun register(
        name: String,
        email: String,
        password: String,
        password_confirmation: String
    ): Result<String>

    suspend fun verifyOtp(
        email: String,
        code: String
    ): Result<String>
}