package com.pamlanjut.evolvance20.domain.model

data class MentoringModel(
    val tanggal: String,
    val jam: String,
    val durasi: String,
    val bidangPekerjaan: String,
    val status: String,
    val linkKonsultasi: String?,
    val linkDokuman: String?
)