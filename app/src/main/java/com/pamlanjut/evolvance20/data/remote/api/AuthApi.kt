package com.pamlanjut.evolvance20.data.remote.api

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

    @POST("auth/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): Response<RegisterResponse>

    @POST("auth/verify")
    suspend fun verifyOtp(
        @Body request: VerifyOtpRequest
    ): Response<RegisterResponse>
}

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    @SerializedName("access_token")
    val accessToken: String
)

data class RegisterRequest(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val password_confirmation: String = ""
)

data class RegisterResponse(
    val success: Boolean,
    val message: String
)

data class VerifyOtpRequest(
    val email: String,
    val code: String
)