package com.pamlanjut.evolvance20.data.repository.bootcamp

import com.pamlanjut.evolvance20.domain.model.Bootcamp

interface BootcampRepository {
    suspend fun getBootcampsData(): List<Bootcamp>
    suspend fun getBootcampRegistered(): List<Bootcamp>
}