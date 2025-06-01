package com.pamlanjut.evolvance20.data.repository.checkout

import com.pamlanjut.evolvance20.data.remote.api.CheckoutApi
import com.pamlanjut.evolvance20.data.repository.authentication.AuthRepository
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class CheckoutRepositoryImpl @Inject constructor(
    private val api: CheckoutApi,
    private val authRepository: AuthRepository
): CheckoutRepository {
    override suspend fun createOrder(id: Int): String {
        val token = authRepository.getToken().firstOrNull() ?: ""

        val response = api.createOrder(
            "Bearer $token", id
        )
        if (response.isSuccessful) {
            return response.body()?.message ?: ""
        } else {
            throw Exception("Failed to create order")
        }
    }
}