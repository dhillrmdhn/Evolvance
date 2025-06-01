package com.pamlanjut.evolvance20.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface BootcampApi {
    @GET("bootcamps")
    suspend fun getBootcampData(
        @Header("Authorization") token: String
    ): Response<BootcampResponse>

    @GET("bootcamps/my")
    suspend fun getBootcampRegistered(
        @Header("Authorization") token: String
    ): Response<List<BootcampDto>>

    @GET("bootcamps/{id}")
    suspend fun getBootcampDetail(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<BootcampDetailResponse>
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

data class BootcampDetailResponse(
    val success: Boolean,
    val data: BootcampDetailDto
)
data class BootcampDetailDto(
    val id: Int,
    val image: String,
    val name: String,
    val description: String,
    val start_date: String?,
    val end_date: String?,
    val price: String,
    val kuota: Int,
    val tipe_pembelajaran: String,
    val bidang_pekerjaan: String,
    val weeks: List<WeekDto>? = null
)
data class WeekDto(
    val id: Int,
    val bootcamp_id: Int,
    val week_number: Int,
    val start_date: String?,
    val end_date: String?,
    val status: String,
    val assignment: AssignmentDto? = null,
    val material: MaterialDto? = null
)
data class AssignmentDto(
    val id: Int,
    val week_id: Int,
    val description: String,
    val due_date: String?,
    val submission: SubmissionDto? = null
)
data class SubmissionDto(
    val id: Int,
    val assignment_id: Int,
    val user_id: Int,
    val file_path: String,
)
data class MaterialDto(
    val id: Int,
    val week_id: Int,
    val video_url: String,
)