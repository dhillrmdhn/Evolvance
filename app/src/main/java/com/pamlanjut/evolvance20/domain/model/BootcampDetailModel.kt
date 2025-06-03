package com.pamlanjut.evolvance20.domain.model

data class BootcampDetail(
    val id: Int,
    val image: String,
    val name: String,
    val description: String,
    val startDate: String?,
    val endDate: String?,
    val price: String,
    val kuota: Int,
    val tipePembelajaran: String,
    val bidangPekerjaan: String,
    val weeks: List<Week>? = null
)

data class Week(
    val id: Int,
    val bootcampId: Int,
    val weekNumber: Int,
    val startDate: String?,
    val endDate: String?,
    val status: String,
    val assignment: Assignment? = null,
    val material: Material? = null
)

data class Assignment(
    val id: Int,
    val weekId: Int,
    val description: String,
    val dueDate: String?,
    val submission: Submission? = null
)

data class Submission(
    val id: Int,
    val assignmentId: Int,
    val userId: Int,
    val filePath: String,
)

data class Material(
    val id: Int,
    val weekId: Int,
    val videoUrl: String,
)