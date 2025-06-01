package com.pamlanjut.evolvance20.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface BootcampApi {
    @GET("bootcamps")
    suspend fun getBootcampData(
        @Header("Authorization") token: String
    ): Response<BootcampResponse>

    @GET("bootcamps/my")
    suspend fun getBootcampRegistered(
        @Header("Authorization") token: String
    ): Response<List<BootcampDto>>
}

data class BootcampResponse(
    val success: Boolean,
    val data: List<BootcampDto>
)

data class BootcampDto(
    val id: Int,
    val image: String,
    val name: String,
    val description: String,
    val start_date: String,
    val end_date: String,
    val price: String,
    val kuota: Int,
    val tipe_pembelajaran: String,
    val bidang_pekerjaan: String,
    val softskills: List<SoftskillDto>? = null
)

data class SoftskillDto(
    val id: Int,
    val name: String
)