package com.pamlanjut.evolvance20.domain.model

data class Bootcamp(
    val id: Int,
    val image: String,
    val name: String,
    val description: String,
    val startDate: String,
    val endDate: String,
    val price: String,
    val kuota: Int,
    val tipePembelajaran: String,
    val bidangPekerjaan: String,
    val softskills: List<Softskill>
)

data class Softskill(
    val id: Int,
    val name: String
)