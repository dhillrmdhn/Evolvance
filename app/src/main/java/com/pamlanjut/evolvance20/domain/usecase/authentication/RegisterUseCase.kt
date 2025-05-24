package com.pamlanjut.evolvance20.domain.usecase.authentication

import com.pamlanjut.evolvance20.data.remote.api.RegisterRequest
import com.pamlanjut.evolvance20.data.remote.api.RegisterResponse
import com.pamlanjut.evolvance20.data.repository.authentication.AuthRepository
import com.pamlanjut.evolvance20.utils.Result
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend fun execute(
        request: RegisterRequest
    ): Result<String> {
        return repository.register(
            name = request.name,
            email = request.email,
            password = request.password,
            password_confirmation = request.password_confirmation
        )
    }
}