package com.pamlanjut.evolvance20.view.mentoring.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pamlanjut.evolvance20.R

@Composable
fun HeaderCard(
    onClickBidang: () -> Unit,
    onClickHistory: () -> Unit,
    isHistory: Boolean = false
) {
    Row(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .border(
                1.5.dp, Color.LightGray, RoundedCornerShape(6.dp)
            )
            .padding(20.dp, 26.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            Modifier.weight(1f).clickable {
                onClickBidang()
            },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Bidang Pekerjaan",
                fontWeight = FontWeight.Bold,
                color = if (isHistory) Color.Gray else colorResource(R.color.main_color)
            )
            Box(
                Modifier
                    .width(50.dp)
                    .height(2.dp)
                    .background(if (isHistory) Color.Gray else colorResource(R.color.main_color))
            )
        }
        Column(
            Modifier.weight(1f).clickable { onClickHistory() },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Riwayat Pembelian",
                fontWeight = FontWeight.Bold,
                color = if (isHistory) colorResource(R.color.main_color) else Color.Gray
            )
            Box(
                Modifier
                    .width(50.dp)
                    .height(2.dp)
                    .background(if (isHistory) colorResource(R.color.main_color) else Color.Gray)
            )
        }
    }
}