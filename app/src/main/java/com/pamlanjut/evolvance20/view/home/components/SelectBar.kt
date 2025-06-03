package com.pamlanjut.evolvance20.view.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pamlanjut.evolvance20.R

@Composable
fun SelectBar(
    navController: NavController
) {
    val option = listOf(
        SelectBarOption(R.drawable.icon_bootcamp, "Bootcamp", {navController.navigate("bootcamp")}),
        SelectBarOption(R.drawable.icon_mentoring, "Mentoring", {navController.navigate("mentoring")}),
        SelectBarOption(R.drawable.icon_cvscooring, "CV Scooring", {navController.navigate("cvscooring")}),
        SelectBarOption(R.drawable.icon_career, "Karir", {navController.navigate("career")}),
        SelectBarOption(R.drawable.icon_feedback, "Feedback", {navController.navigate("feedback")})
    )

    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        option.forEach { it ->
            Column(
                Modifier.clickable { it.navigate() },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(3.dp),
            ) {
                Image(
                    painter = painterResource(it.image),
                    contentDescription = it.name,
                    Modifier.size(50.dp)
                )
                Text(
                    it.name,
                    fontSize = 13.sp
                )
            }
        }
    }
}

data class SelectBarOption(
    @DrawableRes
    val image: Int,
    val name: String,
    val navigate: () -> Unit
)