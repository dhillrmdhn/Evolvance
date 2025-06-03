package com.pamlanjut.evolvance20.data.repository.bootcamp

import com.pamlanjut.evolvance20.domain.model.Bootcamp
import com.pamlanjut.evolvance20.domain.model.BootcampDetail

interface BootcampRepository {
    suspend fun getBootcampsData(): List<Bootcamp>
    suspend fun getBootcampRegistered(): List<Bootcamp>
    suspend fun getBootcampDetail(id: Int): BootcampDetail
}