package com.pamlanjut.evolvance20.data.local.static

import com.pamlanjut.evolvance20.R

data class MentoringData(
    val name: String,
    val image: Int
)

val MentoringDataList: List<MentoringData> = listOf(
    MentoringData("Teknologi dan Data", R.drawable.icon_technology),
    MentoringData("Bisnis dan Manajemen", R.drawable.icon_dollar),
    MentoringData("Kesehatan dan Medis", R.drawable.icon_stethoscope),
    MentoringData("Pendidikan dan Pelatihan", R.drawable.icon_blackboard),
    MentoringData("Marketing dan Komunikasi", R.drawable.icon_marketing),
    MentoringData("Human Development", R.drawable.icon_business),
    MentoringData("Administrasi", R.drawable.icon_calculator),
    MentoringData("Kreatif Digital", R.drawable.icon_creativedesign)
)