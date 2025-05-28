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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.view.bootcamp.components.BootcampCard
import com.pamlanjut.evolvance20.view.components.SearchBox
import com.pamlanjut.evolvance20.view.components.layout.MainLayout

@Preview(showBackground = true)
@Composable
fun BootcampScreen() {
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

            //Content
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(4) {
                    BootcampCard()
                }
            }
        }
    }
}