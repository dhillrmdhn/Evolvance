package com.pamlanjut.evolvance20.utils.helper

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun formatTanggal(tanggal: String): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
    val outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale("id", "ID"))
    val date = LocalDate.parse(tanggal, inputFormatter)
    return date.format(outputFormatter)
}