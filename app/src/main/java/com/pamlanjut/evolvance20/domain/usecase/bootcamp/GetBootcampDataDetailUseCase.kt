package com.pamlanjut.evolvance20.domain.usecase.bootcamp

import com.pamlanjut.evolvance20.data.repository.bootcamp.BootcampRepository
import com.pamlanjut.evolvance20.domain.model.BootcampDetail
import com.pamlanjut.evolvance20.utils.helper.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBootcampDataDetailUseCase @Inject constructor(
    private val repository: BootcampRepository
) {
    operator fun invoke(id: Int): Flow<Resource<BootcampDetail>> = flow {
        emit(Resource.Loading)

        try {
            val data = repository.getBootcampDetail(id)
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unexpected error"))
        }
    }
}