package com.pamlanjut.evolvance20.view.bootcamp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pamlanjut.evolvance20.R

@Preview(showBackground = true)
@Composable
fun BootcampCard() {
    Card(
        Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Column(
            Modifier.heightIn(min = 200.dp)
        ) {
            Box(
                Modifier.height(100.dp)
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_launcher_background,
                    ),
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "Bootcamp Image",
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                Modifier
                    .padding(10.dp, 6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    "Ready2Work: Soft Skill Accelerator by Nestlé",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
                Text(
                    "Bisnis dan Management",
                    Modifier
                        .clip(RoundedCornerShape(3.dp))
                        .background(colorResource(R.color.secondary_color))
                        .padding(12.dp, 4.dp),
                    color = Color.White,
                    fontSize = 8.sp
                )
                FlowRow(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    repeat(4) {
                        Text(
                            "Bismillah",
                            Modifier
                                .clip(RoundedCornerShape(3.dp))
                                .background(colorResource(R.color.third_color))
                                .padding(12.dp, 4.dp),
                            color = Color.White,
                            fontSize = 8.sp
                        )
                    }
                }
            }
        }
    }
}