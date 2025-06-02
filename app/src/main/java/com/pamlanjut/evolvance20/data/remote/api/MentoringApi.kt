package com.pamlanjut.evolvance20.data.remote.api

import com.pamlanjut.evolvance20.domain.model.MentoringModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface MentoringApi {
    @POST("mentorings")
    suspend fun createOrder(
        @Header("Authorization") token: String,
        @Body request: MentoringModel
    ): Response<MentoringResponse>
}

data class MentoringResponse(
    val message: String,
    val data: MentoringModel
)