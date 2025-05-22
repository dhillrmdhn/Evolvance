package com.pamlanjut.evolvance20.domain.usecase.authentication

import com.pamlanjut.evolvance20.data.repository.authentication.AuthRepository
import com.pamlanjut.evolvance20.domain.model.AuthTokenModel
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend fun execute(
        email: String,
        password: String
    ): AuthTokenModel {
        val token = repository.login(
            email, password
        )
        repository.saveToken(token.accessToken)

        return token
    }
}