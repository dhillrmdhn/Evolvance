package com.pamlanjut.evolvance20.view.mentoring.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.data.local.static.MentoringData

@Composable
fun MentoringCard(
    mentoringData: MentoringData,
    onClick: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .height(225.dp)
            .shadow(1.5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .clickable {
                onClick()
            }
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(
                id = mentoringData.image
            ),
            contentDescription = "Mentoring Image",
            Modifier
                .size(100.dp)
        )
        Spacer(
            Modifier.height(12.dp)
        )
        Text(
            mentoringData.name,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
        )
    }
}