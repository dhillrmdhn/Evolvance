package com.pamlanjut.evolvance20.domain.usecase.mentoring

import com.pamlanjut.evolvance20.data.repository.mentoring.MentoringRepository
import com.pamlanjut.evolvance20.domain.model.MentoringModel
import javax.inject.Inject

class CreateMentoringOrderUseCase @Inject constructor(
    private val repository: MentoringRepository
) {

    suspend operator fun invoke(mentoringRequest: MentoringModel): MentoringModel {
        return repository.createOrder(mentoringRequest)
    }
}
