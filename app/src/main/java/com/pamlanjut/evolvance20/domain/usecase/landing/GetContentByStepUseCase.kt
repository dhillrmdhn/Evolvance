package com.pamlanjut.evolvance20.domain.usecase.landing

import com.pamlanjut.evolvance20.data.repository.landing.LandingRepository
import com.pamlanjut.evolvance20.domain.model.LandingProgressModel
import javax.inject.Inject

class GetContentByStepUseCase @Inject constructor(
    private val repository: LandingRepository
) {
    operator fun invoke(
        count: Int
    ): LandingProgressModel {
        return repository.getContentByStep(count)
    }
}