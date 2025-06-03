package com.pamlanjut.evolvance20.data.repository.checkout

interface CheckoutRepository {
    suspend fun createOrder(
        id: Int
    ): String
}