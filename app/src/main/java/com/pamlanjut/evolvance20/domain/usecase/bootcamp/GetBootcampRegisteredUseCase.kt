package com.pamlanjut.evolvance20.domain.usecase.bootcamp

import com.pamlanjut.evolvance20.data.repository.bootcamp.BootcampRepository
import com.pamlanjut.evolvance20.domain.model.Bootcamp
import com.pamlanjut.evolvance20.utils.helper.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBootcampRegisteredUseCase @Inject constructor(
    private val repository: BootcampRepository
) {
    operator fun invoke(): Flow<Resource<List<Bootcamp>>> = flow {
        emit(Resource.Loading)

        try {
            val data = repository.getBootcampRegistered()
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unexpected error"))
        }
    }
}