package com.pamlanjut.evolvance20.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.view.components.BannerCarousel
import com.pamlanjut.evolvance20.view.components.layout.MainLayout
import com.pamlanjut.evolvance20.view.home.components.NotAvailableCard
import com.pamlanjut.evolvance20.view.home.components.SelectBar
import com.pamlanjut.evolvance20.view.home.components.TaskNowCard

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val imageUrls = listOf(
        R.drawable.banner_1,
        R.drawable.banner_2,
    )
    val hasBootcamp by viewModel.hasBootcamp.collectAsState()

    MainLayout(showBottomBar = true, content = {
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            // Heading
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    "Event Mendatang",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                BannerCarousel(
                    imageList = imageUrls
                )
            }

            // Select Bar
            SelectBar(
                navController
            )

            //TaskNowBar
            Text(
                "Target Minggu Ini",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            if (hasBootcamp) TaskNowCard() else NotAvailableCard()
        }
    })
}