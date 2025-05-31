package com.pamlanjut.evolvance20.view.bootcamp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.domain.model.Bootcamp
import com.pamlanjut.evolvance20.utils.helper.Resource
import com.pamlanjut.evolvance20.view.bootcamp.components.BootcampCard
import com.pamlanjut.evolvance20.view.components.LoadingScreen
import com.pamlanjut.evolvance20.view.components.SearchBox
import com.pamlanjut.evolvance20.view.components.layout.MainLayout

@Composable
fun BootcampScreen(
    viewModel: BootcampViewModel,
    navController: NavController
) {
    val state by viewModel.state.collectAsState()

    MainLayout {
        Column(
            Modifier
                .fillMaxSize()
                .padding(18.dp, 24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Search Bar
            Row(
                Modifier.padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                SearchBox(
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            Color.Gray.copy(alpha = 0.2f), RoundedCornerShape(12.dp)
                        )
                )
                IconButton(
                    onClick = {},
                    Modifier
                        .clip(CircleShape)
                        .background(Color.Gray.copy(alpha = 0.2f))
                ) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.icon_filter
                        ),
                        contentDescription = "Filter Icons",
                        Modifier.size(20.dp)
                    )
                }
            }

            when (state) {
                is Resource.Idle -> LoadingScreen()
                is Resource.Loading -> LoadingScreen()
                is Resource.Success -> {
                    val bootcamps = (state as Resource.Success<List<Bootcamp>>).data

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 30.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(bootcamps.size) { index ->
                            val bootcamp = bootcamps[index]
                            BootcampCard(
                                image = bootcamp.image,
                                title = bootcamp.name,
                                category = bootcamp.bidangPekerjaan,
                                softskills = bootcamp.softskills,
                                onClick = {
                                    navController.navigate(
                                        "bootcamp/detail/${bootcamp.id}"
                                    )
                                }
                            )
                        }
                    }
                }

                is Resource.Error -> Text("Terjadi error: ${(state as Resource.Error).message}")
            }
        }
    }
}