package com.pamlanjut.evolvance20.data.repository.mentoring

import com.pamlanjut.evolvance20.domain.model.MentoringModel

interface MentoringRepository {
    suspend fun createOrder(
        mentoringRequest: MentoringModel
    ): MentoringModel
}