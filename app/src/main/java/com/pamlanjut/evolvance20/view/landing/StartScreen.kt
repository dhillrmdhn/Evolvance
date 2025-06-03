package com.pamlanjut.evolvance20.view.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.view.components.Button

@Composable
fun StartScreen(
    onStart: () -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.background_landing),
            contentDescription = "",
            Modifier.matchParentSize()
        )

        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp, 64.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    "Bersama Kami",
                    fontSize = 18.sp
                )
                Text(
                    "Temukan Potensi, \nBangun Masa Depanmu",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 30.sp
                )

                Spacer(
                    Modifier.height(20.dp)
                )

                Button(
                    onClick = {
                        onStart()
                    },
                    text = "Mulai"
                )
            }
        }
    }
}