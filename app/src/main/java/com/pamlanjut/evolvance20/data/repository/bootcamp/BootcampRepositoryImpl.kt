package com.pamlanjut.evolvance20.data.repository.bootcamp

import com.pamlanjut.evolvance20.data.remote.api.BootcampApi
import com.pamlanjut.evolvance20.data.repository.authentication.AuthRepository
import com.pamlanjut.evolvance20.domain.model.Bootcamp
import com.pamlanjut.evolvance20.utils.mapper.toDomain
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class BootcampRepositoryImpl @Inject constructor(
    private val api: BootcampApi,
    private val authRepository: AuthRepository
) : BootcampRepository {
    override suspend fun getBootcampsData(): List<Bootcamp> {
        val token = authRepository.getToken().firstOrNull() ?: ""

        val response = api.getBootcampData("Bearer $token")
        if (response.isSuccessful) {
            return response.body()?.data?.map { it.toDomain() } ?: emptyList()
        } else {
            throw Exception("Failed to fetch bootcamps data")
        }
    }

    override suspend fun getBootcampRegistered(): List<Bootcamp> {
        val token = authRepository.getToken().firstOrNull() ?: ""

        val response = api.getBootcampRegistered("Bearer $token")
        if (response.isSuccessful) {
            return response.body()?.map { it.toDomain() } ?: emptyList()
        } else {
            throw Exception("Failed to fetch registered bootcamps data")
        }
    }

}