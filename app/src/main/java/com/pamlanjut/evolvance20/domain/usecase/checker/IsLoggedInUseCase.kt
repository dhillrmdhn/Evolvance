package com.pamlanjut.evolvance20.domain.usecase.checker

import com.pamlanjut.evolvance20.data.repository.authentication.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class IsLoggedInUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.getToken().map {
            !it.isNullOrEmpty()
        }
    }
}