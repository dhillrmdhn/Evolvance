package com.pamlanjut.evolvance20.data.repository.mentoring

import com.pamlanjut.evolvance20.data.remote.api.MentoringApi
import com.pamlanjut.evolvance20.data.repository.authentication.AuthRepository
import com.pamlanjut.evolvance20.domain.model.MentoringModel
import com.pamlanjut.evolvance20.utils.mapper.toDomain
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class MentoringRepositoryImpl @Inject constructor(
    private val api: MentoringApi,
    private val repository: AuthRepository
): MentoringRepository {
    override suspend fun createOrder(mentoringRequest: MentoringModel): MentoringModel {
        val token = repository.getToken().firstOrNull() ?: ""
        val response = api.createOrder("Bearer $token", mentoringRequest)

        if (response.isSuccessful) {
            return response.body()?.data?.copy()
                ?: throw Exception("Data kosong")
        } else {
            throw Exception("Failed to create order: ${response.message()}")
        }
    }
}