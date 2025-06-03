package com.pamlanjut.evolvance20.domain.model

data class UserModel(
    val name: String,
    val email: String,
    val role: String,
    val phone: String?,
    val address: String?,
)