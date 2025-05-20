package com.pamlanjut.evolvance20.data.repository.landing

import com.pamlanjut.evolvance20.domain.model.LandingProgressModel

interface LandingRepository {
    fun getContentByStep(
        count: Int
    ): LandingProgressModel
}