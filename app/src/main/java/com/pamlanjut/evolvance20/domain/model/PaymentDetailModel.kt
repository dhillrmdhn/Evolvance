package com.pamlanjut.evolvance20.domain.model

data class PaymentDetail(
    val id: Int,
    val name: String,
    val price: String,
    val paymentMethod: String?,
    val paymentDate: String?,
    val paymentReference: Long?
)