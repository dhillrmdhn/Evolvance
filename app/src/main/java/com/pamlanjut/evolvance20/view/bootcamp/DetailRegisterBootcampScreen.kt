package com.pamlanjut.evolvance20.view.bootcamp

import android.graphics.Paint.Align
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.view.bootcamp.components.BenefitCard
import com.pamlanjut.evolvance20.view.bootcamp.components.RincianCard
import com.pamlanjut.evolvance20.view.components.Button
import com.pamlanjut.evolvance20.view.components.layout.BootcampLayout

@Preview(showBackground = true)
@Composable
fun DetailRegisterBootcampScreen() {
    val listBenefitsData = listOf(
        BenefitsData("Sertifikasi", R.drawable.icon_trophy),
        BenefitsData("E-Book dan Video", R.drawable.icon_paper),
        BenefitsData("2 Kali Sesi Mentoring", R.drawable.icon_computer),
        BenefitsData("Networking", R.drawable.icon_doubleperson)
    )

    val rincianDetail: List<RincianDetail> = listOf(
        RincianDetail("Tanggal", "25 Mei 2025"),
        RincianDetail("Kuota", "200 Siswa"),
        RincianDetail("Pembelajaran", "Hybrid")
    )

    BootcampLayout {
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
                    "Telkom Future Talent Bootcamp adalah program pelatihan intensif yang dirancang untuk membentuk generasi profesional digital masa depan. Melalui kurikulum berbasis industri, peserta akan dibekali keterampilan teknologi terkini seperti cloud computing, data analytics, cybersecurity, dan digital leadership. Dipandu langsung oleh praktisi Telkom Indonesia dan mentor berpengalaman, bootcamp ini memberikan pengalaman belajar berbasis proyek nyata yang mempersiapkan peserta untuk menghadapi tantangan di dunia kerja digital. Program ini terbuka untuk mahasiswa, fresh graduate, dan profesional muda yang ingin mempercepat karier di dunia teknologi.",
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
                rincianDetail.forEach{
                        it -> RincianCard(
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
    }
}

data class BenefitsData(
    val name: String,
    val icon: Int
)

data class RincianDetail(
    val name: String,
    val description: String
)