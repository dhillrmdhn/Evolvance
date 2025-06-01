package com.pamlanjut.evolvance20.view.bootcamp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.domain.model.BootcampDetail
import com.pamlanjut.evolvance20.utils.helper.Resource
import com.pamlanjut.evolvance20.view.bootcamp.components.ChallengeCard
import com.pamlanjut.evolvance20.view.components.LoadingScreen

@Composable
fun DetailContentBootcamp(
    id: Int,
    viewModel: BootcampViewModel
) {
    LaunchedEffect(Unit) {
        viewModel.fetchBootcampDetail(id)
        println("Navigated with id: $id")
    }

    val data by viewModel.detailState.collectAsState()
    when (data) {
        is Resource.Idle -> LoadingScreen()
        is Resource.Loading -> LoadingScreen()
        is Resource.Success -> {
            val bootcamps = (data as Resource.Success<BootcampDetail>).data
            println("BootcampData bang: $bootcamps")

            DetailContentLayout(bootcamps)
        }
        is Resource.Error -> Text("Terjadi error: ${(data as Resource.Error).message}")
        else -> {}
    }
}

@Composable
fun DetailContentLayout(
    bootcamps: BootcampDetail
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp, 24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Header
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                AsyncImage(
                    model = bootcamps.image,
                    contentDescription = "Background Bootcamp",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(
                            RoundedCornerShape(16.dp)
                        )
                )
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
                Text(
                    "Link Group dan Online Meeting",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.baseline_link_24),
                        contentDescription = "Link Icon"
                    )
                    Text(
                        "Link Group Discord",
                        textDecoration = TextDecoration.Underline,
                        color = colorResource(R.color.main_color)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.baseline_link_24),
                        contentDescription = "Link Icon"
                    )
                    Text(
                        "Link Group Discord",
                        textDecoration = TextDecoration.Underline,
                        color = colorResource(R.color.main_color)
                    )
                }
            }
        }

        // Spacer
        item {
            Spacer(
                Modifier.height(16.dp)
            )
        }

        // Content
        item {
            Text(
                "Tantangan Mingguan",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        itemsIndexed(bootcamps.weeks ?: emptyList()) { index, week ->
            ChallengeCard(
                week = week,
                index = index
            )
        }
    }
}