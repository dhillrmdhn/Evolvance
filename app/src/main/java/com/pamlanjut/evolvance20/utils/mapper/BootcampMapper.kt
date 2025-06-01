package com.pamlanjut.evolvance20.utils.mapper

import com.pamlanjut.evolvance20.data.remote.api.BootcampDto
import com.pamlanjut.evolvance20.data.remote.api.SoftskillDto
import com.pamlanjut.evolvance20.domain.model.Bootcamp
import com.pamlanjut.evolvance20.domain.model.Softskill

fun BootcampDto.toDomain(): Bootcamp = Bootcamp(
    id = id,
    image = "https://evolvanceapi.kuncipintu.my.id/api/${image}",
    name = name,
    description = description,
    startDate = start_date,
    endDate = end_date,
    price = price,
    kuota = kuota,
    tipePembelajaran = tipe_pembelajaran,
    bidangPekerjaan = bidang_pekerjaan,
    softskills = softskills?.map { it.toDomain() }
)

fun SoftskillDto.toDomain(): Softskill = Softskill(
    id = id,
    name = name
)