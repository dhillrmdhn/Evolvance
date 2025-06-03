package com.pamlanjut.evolvance20.domain.usecase.checkout

import com.pamlanjut.evolvance20.data.repository.checkout.CheckoutRepository
import com.pamlanjut.evolvance20.utils.helper.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CreateOrderBootcampUseCase @Inject constructor(
    private val repository: CheckoutRepository
) {
    operator fun invoke(id: Int): Flow<Resource<String>> = flow {
        emit(Resource.Loading)

        try {
            val data = repository.createOrder(id)
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unexpected error"))
        }
    }
}