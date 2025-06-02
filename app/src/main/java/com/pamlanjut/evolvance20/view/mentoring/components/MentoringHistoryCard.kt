package com.pamlanjut.evolvance20.view.mentoring.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.domain.model.MentoringModel
import com.pamlanjut.evolvance20.view.mentoring.MentoringViewModel

@Composable
fun MentoringHistoryCard(
    mentoringModel: MentoringModel,
    viewModel: MentoringViewModel,
    navController: NavController
) {
    Row(
        Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray, RoundedCornerShape(10.dp))
            .padding(24.dp, 10.dp)
            .clickable {
                navController.navigate("mentoring/payment")
                viewModel.setMentoringData(mentoringModel)
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            Modifier.weight(6f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.avatar),
                contentDescription = "",
                Modifier.size(40.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Text(
                    "Reuben Razani"
                )
                Text(
                    mentoringModel.bidangPekerjaan,
                    fontSize = 12.sp
                )
            }
        }

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Check",
            Modifier.size(30.dp).weight(1f),
            tint = colorResource(R.color.main_color)
        )
    }
}