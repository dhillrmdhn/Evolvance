package com.pamlanjut.evolvance20.domain.usecase.authentication

import com.pamlanjut.evolvance20.data.remote.api.VerifyOtpRequest
import com.pamlanjut.evolvance20.data.repository.authentication.AuthRepository
import com.pamlanjut.evolvance20.utils.helper.Result
import javax.inject.Inject

class VerifyOtpUseCase @Inject constructor(
    private val repository: AuthRepository
){

    suspend fun execute(
        request: VerifyOtpRequest
    ): Result<String> {
        return repository.verifyOtp(
            email = request.email,
            code = request.code
        )
    }
}