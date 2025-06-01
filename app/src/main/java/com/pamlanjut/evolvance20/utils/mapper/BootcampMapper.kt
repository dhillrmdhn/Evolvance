package com.pamlanjut.evolvance20.utils.mapper

import com.pamlanjut.evolvance20.data.remote.api.AssignmentDto
import com.pamlanjut.evolvance20.data.remote.api.BootcampDetailDto
import com.pamlanjut.evolvance20.data.remote.api.BootcampDto
import com.pamlanjut.evolvance20.data.remote.api.MaterialDto
import com.pamlanjut.evolvance20.data.remote.api.SoftskillDto
import com.pamlanjut.evolvance20.data.remote.api.SubmissionDto
import com.pamlanjut.evolvance20.data.remote.api.WeekDto
import com.pamlanjut.evolvance20.domain.model.Assignment
import com.pamlanjut.evolvance20.domain.model.Bootcamp
import com.pamlanjut.evolvance20.domain.model.BootcampDetail
import com.pamlanjut.evolvance20.domain.model.Material
import com.pamlanjut.evolvance20.domain.model.Softskill
import com.pamlanjut.evolvance20.domain.model.Submission
import com.pamlanjut.evolvance20.domain.model.Week

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

fun BootcampDetailDto.toDomain(): BootcampDetail = BootcampDetail(
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
    weeks = weeks?.map { it.toDomain() }
)

fun WeekDto.toDomain(): Week = Week(
    id = id,
    bootcampId = bootcamp_id,
    weekNumber = week_number,
    startDate = start_date,
    endDate = end_date,
    status = status,
    assignment = assignment?.toDomain(),
    material = material?.toDomain()
)

fun AssignmentDto.toDomain(): Assignment = Assignment(
    id = id,
    weekId = week_id,
    description = description,
    dueDate = due_date,
    submission = submission?.toDomain()
)

fun SubmissionDto.toDomain(): Submission = Submission(
    id = id,
    assignmentId = assignment_id,
    userId = user_id,
    filePath = file_path
)

fun MaterialDto.toDomain(): Material = Material(
    id = id,
    weekId = week_id,
    videoUrl = video_url
)