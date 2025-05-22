package com.pamlanjut.evolvance20.data.repository.authentication

import com.pamlanjut.evolvance20.domain.model.AuthTokenModel

interface AuthRepository {
    suspend fun login(
        email: String,
        password: String
    ): AuthTokenModel

    suspend fun saveToken(
        token: String
    )
}