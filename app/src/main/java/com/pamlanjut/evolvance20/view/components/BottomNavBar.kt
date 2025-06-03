package com.pamlanjut.evolvance20.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pamlanjut.evolvance20.R

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Card(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .height(81.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .shadow(elevation = 4.dp, RoundedCornerShape(16.dp))
            .border(0.5.dp, Color.LightGray, RoundedCornerShape(16.dp))
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier.clickable {
                    navController.navigate("home")
                },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_home_24),
                    contentDescription = "Home",
                    colorFilter = ColorFilter.tint(colorResource(R.color.main_color)),
                )
                Text(
                    "Beranda",
                    fontSize = 12.sp,
                    color = colorResource(R.color.main_color)
                )
            }
            Column(
                Modifier.clickable {
                    navController.navigate("mentoring/history")
                },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_access_time_filled_24),
                    contentDescription = "Riwayat",
                    colorFilter = ColorFilter.tint(colorResource(R.color.main_color)),
                )
                Text(
                    "Riwayat",
                    fontSize = 12.sp,
                    color = colorResource(R.color.main_color)
                )
            }
            Column(
                Modifier.clickable {
                    navController.navigate("notification")
                },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_notifications_24),
                    contentDescription = "Notifikasi",
                    colorFilter = ColorFilter.tint(colorResource(R.color.main_color)),
                )
                Text(
                    "Notifikasi",
                    fontSize = 12.sp,
                    color = colorResource(R.color.main_color)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_person_24),
                    contentDescription = "Person",
                    colorFilter = ColorFilter.tint(colorResource(R.color.main_color)),
                )
                Text(
                    "Profile",
                    fontSize = 12.sp,
                    color = colorResource(R.color.main_color)
                )
            }
        }
    }
}