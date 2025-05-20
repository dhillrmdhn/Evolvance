package com.pamlanjut.evolvance20.data.repository.landing

import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.domain.model.LandingProgressModel
import javax.inject.Inject

class LandingRepositoryImpl @Inject constructor() : LandingRepository {
    override fun getContentByStep(count: Int): LandingProgressModel {
        return when (count) {
            1 -> LandingProgressModel(
                "Bersama Kami, Kamu Bisa Lebih Siap Bekerja!",
                "Dapatkan pelatihan interaktif dan tantangan nyata untuk tumbuh jadi versi terbaikmu.",
                R.drawable.landing2
            )
            2 -> LandingProgressModel(
                "Kurangi Pengangguran, Bangun Masa Depan!",
                "Yuk, ubah potensi jadi prestasi dengan bekal skill yang relevan dan aplikatif.",
                R.drawable.landing3
            )
            else -> LandingProgressModel(
                "Ayo! Siapkan Dirimu untuk Dunia Kerja!",
                "Bangun softskill yang dibutuhkan industri, mulai dari komunikasi, kepemimpinan, hingga problem solving.",
                R.drawable.landing1
            )
        }
    }
}