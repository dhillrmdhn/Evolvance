package com.pamlanjut.evolvance20.data.repository.authentication

import com.pamlanjut.evolvance20.data.local.AuthPreference
import com.pamlanjut.evolvance20.data.remote.api.AuthApi
import com.pamlanjut.evolvance20.data.remote.api.LoginRequest
import com.pamlanjut.evolvance20.data.remote.api.RegisterRequest
import com.pamlanjut.evolvance20.data.remote.api.VerifyOtpRequest
import com.pamlanjut.evolvance20.domain.model.AuthTokenModel
import com.pamlanjut.evolvance20.utils.helper.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val preference: AuthPreference
) : AuthRepository {
    override suspend fun login(email: String, password: String): AuthTokenModel {
        val response = api.login(
            LoginRequest(email, password)
        )
        return AuthTokenModel(response.accessToken)
    }

    override suspend fun saveToken(token: String) {
        preference.saveAccessToken(token)
    }

    override fun getToken(): Flow<String?> {
        return preference.getAccessToken()
    }

    override suspend fun clearDataStore() {
        preference.clearDataStore()
    }

    override suspend fun register(
        name: String,
        email: String,
        password: String,
        password_confirmation: String
    ): Result<String> {
        return try {
            val response = api.register(
                RegisterRequest(
                    name, email, password, password_confirmation
                )
            )

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null && body.success) {
                    Result.Success(body.message)
                } else {
                    Result.Error(body?.message ?: "Registration failed")
                }
            } else {
                val errorMessage = response.errorBody()?.string() ?: "Oops! Something wrong with API Server"
                Result.Error(errorMessage)
            }

        } catch (e: Exception) {
            Result.Error("Something went wrong: $e")
        }
    }

    override suspend fun verifyOtp(email: String, otp: String): Result<String> {
        return try {
            val response = api.verifyOtp(
                VerifyOtpRequest(
                    email, otp
                )
            )

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null && body.success) {
                    Result.Success(body.message)
                } else {
                    Result.Error(body?.message ?: "OTP Verification failed")
                }
            } else {
                val errorMessage = response.errorBody()?.string() ?: "Oops! Something wrong with API Server"
                Result.Error(errorMessage)
            }

        } catch (e: Exception) {
            Result.Error("Something went wrong: $e")
        }
    }
}