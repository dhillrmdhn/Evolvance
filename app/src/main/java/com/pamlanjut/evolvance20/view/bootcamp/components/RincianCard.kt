package com.pamlanjut.evolvance20.view.bootcamp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pamlanjut.evolvance20.view.bootcamp.RincianDetail

@Composable
fun RincianCard(
    rincian: RincianDetail
) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF5F6FFF),
            Color(0xFF4D00FF)
        )
    )

    Row(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .background(gradient)
            .padding(20.dp ,10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = rincian.name,
            color = Color.White,
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = rincian.description,
            color = Color.White,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End
        )
    }
}