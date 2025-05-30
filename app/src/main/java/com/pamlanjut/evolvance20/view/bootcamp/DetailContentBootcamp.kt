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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.view.bootcamp.components.ChallengeCard

@Preview(showBackground = true)
@Composable
fun DetailContentBootcamp() {
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
                Image(
                    painter = painterResource(R.drawable.example_bannerbootcamp),
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
        item {
            ChallengeCard()
        }

    }
}
