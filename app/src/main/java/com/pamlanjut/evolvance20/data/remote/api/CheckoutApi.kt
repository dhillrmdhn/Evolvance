package com.pamlanjut.evolvance20.data.remote.api

import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface CheckoutApi {
    @POST("bootcamps/purchase/{id}")
    suspend fun createOrder(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<CheckoutResponse>
}

data class CheckoutResponse(
    val message: String
)