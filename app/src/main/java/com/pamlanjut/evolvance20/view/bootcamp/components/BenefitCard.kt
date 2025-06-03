package com.pamlanjut.evolvance20.view.bootcamp.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.view.bootcamp.BenefitsData

@Composable
fun BenefitCard(
    modifier: Modifier = Modifier,
    benefitsData: BenefitsData
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(benefitsData.icon),
            contentDescription = "Benefit Icon"
        )
        Text(
            benefitsData.name
        )
    }
}