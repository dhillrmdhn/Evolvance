package com.pamlanjut.evolvance20.view.mentoring

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.view.components.layout.MentoringLayout

@Preview(showBackground = true)
@Composable
fun PaymentMentoring() {
    MentoringLayout(
        content = {ScreenLayout()},
        withPrice = true
    )
}

@Composable
private fun ScreenLayout () {
    Column(
        Modifier
            .fillMaxSize()
            .padding(18.dp, 24.dp)
    ) {
        Text(
            "Status Pembayaran", fontWeight = FontWeight.Bold, fontSize = 18.sp
        )

        Column(
            Modifier
                .fillMaxWidth()
                .padding(0.dp, 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.baseline_check_24
                ),
                contentDescription = "Status Pembayaran",
                Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(
                        colorResource(R.color.main_color)
                    )
                    .padding(5.dp)
            )
            Text(
                "Pembayaran Berhasil",
                color = colorResource(R.color.main_color),
                fontSize = 16.sp
            )
        }

        Column(
            Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text(
                "Rincian Konsultasi", fontWeight = FontWeight.Bold, fontSize = 18.sp
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(Color.White)
                    .shadow(1.dp, RoundedCornerShape(10.dp))
                    .padding(20.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.icon_paper),
                    contentDescription = "Halo",
                    Modifier.size(36.dp)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        "Nama Konsultant",
                        fontSize = 14.sp
                    )
                    Text(
                        "HRD Furmakila",
                        fontSize = 12.sp
                    )
                }
            }

            Column(
                Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Bidang Pekerjaan")
                    Text("")
                }
                Row(
                    Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Tanggal Konsultasi")
                    Text("")
                }
                Row(
                    Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Durasi Konsultasi")
                    Text("")
                }
                Row(
                    Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Status Konsultasi")
                    Text("")
                }
                Row(
                    Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Link Konsultasi")
                    Text(
                        "Url  >",
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.main_color)
                    )
                }
            }
        }
    }
}