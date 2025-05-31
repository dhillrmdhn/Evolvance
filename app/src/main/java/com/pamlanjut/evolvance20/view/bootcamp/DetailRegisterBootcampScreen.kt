package com.pamlanjut.evolvance20.view.bootcamp

import android.graphics.Paint.Align
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.domain.model.Bootcamp
import com.pamlanjut.evolvance20.utils.helper.Resource
import com.pamlanjut.evolvance20.utils.helper.formatTanggal
import com.pamlanjut.evolvance20.view.bootcamp.components.BenefitCard
import com.pamlanjut.evolvance20.view.bootcamp.components.RincianCard
import com.pamlanjut.evolvance20.view.components.Button
import com.pamlanjut.evolvance20.view.components.LoadingScreen
import com.pamlanjut.evolvance20.view.components.layout.BootcampLayout

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DetailRegisterBootcampScreen(
    id: Int,
    viewModel: BootcampViewModel
) {
    val data by viewModel.state.collectAsState()
    when(data) {
        is Resource.Idle -> LoadingScreen()
        is Resource.Loading -> LoadingScreen()
        is Resource.Success -> {
            val bootcamps = (data as Resource.Success<List<Bootcamp>>).data.find { it.id == id }
            if (bootcamps != null) {
                Screen(
                    bootcamp = bootcamps
                )
            } else {
                Text("Bootcamp tidak ditemukan")
            }
        }
        is Resource.Error -> Text("Terjadi error: ${(data as Resource.Error).message}")
        else -> {}
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Screen(
    bootcamp: Bootcamp
) {
    val listBenefitsData = listOf(
        BenefitsData("Sertifikasi", R.drawable.icon_trophy),
        BenefitsData("E-Book dan Video", R.drawable.icon_paper),
        BenefitsData("2 Kali Sesi Mentoring", R.drawable.icon_computer),
        BenefitsData("Networking", R.drawable.icon_doubleperson)
    )

    val rincianDetail: List<RincianDetail> = listOf(
        RincianDetail("Tanggal", "${formatTanggal(bootcamp.startDate)} - ${formatTanggal(bootcamp.endDate)}"),
        RincianDetail("Kuota", "${bootcamp.kuota.toString()} Peserta"),
        RincianDetail("Pembelajaran", bootcamp.tipePembelajaran)
    )

    BootcampLayout(
        content = {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(18.dp, 24.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                // Description
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        "Deskripsi", fontWeight = FontWeight.Bold, fontSize = 16.sp
                    )
                    Text(
                        bootcamp.description,
                        textAlign = TextAlign.Justify
                    )
                }

                //Benefit
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        "Keuntungan bagi Anda",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    FlowRow(
                        Modifier.fillMaxWidth(),
                        maxItemsInEachRow = 2,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        listBenefitsData.forEach { it ->
                            BenefitCard(
                                benefitsData = it,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }

                //Rincian
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        "Rincian Lainnya",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    rincianDetail.forEach { it ->
                        RincianCard(
                            rincian = it,
                        )
                    }
                }

                //Button
                Button(
                    onClick = {},
                    text = "Daftar"
                )
            }
        },
        image = bootcamp.image
    )
}

data class BenefitsData(
    val name: String,
    val icon: Int
)

data class RincianDetail(
    val name: String,
    val description: String
)