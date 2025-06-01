package com.pamlanjut.evolvance20.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pamlanjut.evolvance20.view.components.BannerCarousel
import com.pamlanjut.evolvance20.view.components.layout.MainLayout
import com.pamlanjut.evolvance20.view.home.components.SelectBar

@Composable
fun HomeScreen(
    navController: NavController
) {
    val imageUrls = listOf(
        "https://images.unsplash.com/photo-1606788075761-19b8a3de3c43",
        "https://images.unsplash.com/photo-1506744038136-46273834b3fb",
        "https://images.unsplash.com/photo-1491553895911-0055eca6402d",
        "https://images.unsplash.com/photo-1519125323398-675f0ddb6308"
    )

    MainLayout(showBottomBar = true, content = {
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Heading
            Column {
                Text(
                    "Event Mendatang",
                    fontSize = 24.sp,
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
        }
    })
}