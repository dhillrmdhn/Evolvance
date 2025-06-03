package com.pamlanjut.evolvance20.view.mentoring

import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.view.components.Button
import com.pamlanjut.evolvance20.view.components.layout.MentoringLayout
import com.pamlanjut.evolvance20.view.mentoring.components.DatePicker
import com.pamlanjut.evolvance20.view.mentoring.components.HourPicker
import java.util.Calendar

@Composable
fun MentoringSchedule(
    navController: NavController,
    viewModel: MentoringViewModel
) {
    MentoringLayout(
        { ScreenLayout(navController, viewModel) }
    )
}

@Composable
private fun ScreenLayout(
    navController: NavController,
    viewModel: MentoringViewModel
) {
    val mentoringData by viewModel.mentoringData.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .padding(18.dp, 24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DatePicker(
                selectedDate = mentoringData?.tanggal.orEmpty(),
                onDateSelected = { viewModel.updateTanggal(it) }
            )
            HourPicker(
                selectedTime = mentoringData?.jam.orEmpty(),
                onTimeSelected = { viewModel.updateWaktu(it) }
            )
            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    "Durasi Konsultasi",
                    fontWeight = FontWeight.Bold
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                        .border(1.dp, Color.Gray, RoundedCornerShape(10.dp))
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    BasicTextField(
                        value = "40 Menit",
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }

            // Warning
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .shadow(1.dp, RoundedCornerShape(10.dp))
            ) {
                Image(
                    painter = painterResource(R.drawable.background_warning),
                    contentDescription = "Background Warning",
                    Modifier.matchParentSize(),
                    contentScale = ContentScale.Crop
                )
                Row(
                    Modifier
                        .matchParentSize()
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.White,
                        modifier = Modifier.size(50.dp)
                    )
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            "Peringatan",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                        Text(
                            "Setelah pembayaran berhasil dikonfirmasi, sistem kami akan segera mencocokkan Anda dengan mentor profesional yang tersedia sesuai dengan jadwal yang Anda pilih.",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Justify,
                            color = Color.White
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(40.dp))
        Button(
            onClick = {
                navController.navigate("mentoring/payment")
            },
            text = "Berikutnya"
        )
    }
}