package com.pamlanjut.evolvance20.view.mentoring.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.pamlanjut.evolvance20.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    withPrice: Boolean = false
) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(330.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.background_mentoringlayout),
            contentDescription = "Background Bootcamp",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
                .clip(
                    RoundedCornerShape(
                    bottomStart = 16.dp,
                    bottomEnd = 16.dp
                )
                )
        )

        Column(
            Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.icon_technology),
                contentDescription = "Image",
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(30.dp),
                contentScale = ContentScale.Crop
            )

            Row(
                Modifier
                    .fillMaxWidth(0.85f)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color.White)
                    .height(60.dp)
                    .padding(20.dp, 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    Modifier.weight(3f),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.icon_technology),
                        contentDescription = "Image Description"
                    )
                    Text(
                        "Teknologi dan Data"
                    )
                }
                if (withPrice) {
                    Column(
                        Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Text(
                            "Rp. 100.009,-",
                            fontSize = 12.sp
                        )
                        Text(
                            "+ Pajak",
                            fontSize = 10.sp
                        )
                    }
                }
            }
        }
    }
}