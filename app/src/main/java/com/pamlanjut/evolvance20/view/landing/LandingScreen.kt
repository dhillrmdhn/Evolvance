package com.pamlanjut.evolvance20.view.landing

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pamlanjut.evolvance20.R

@Composable
fun LandingScreen(
    viewModel: LandingViewModel,
    navController: NavController
) {
    val progressValue = viewModel.textData.value
    val count = viewModel.count.value

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp, 75.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logotext),
                contentDescription = "Logo Text Evolvance",
                modifier = Modifier
                    .graphicsLayer {
                        scaleX = 2f
                        scaleY = 2f
                    }
                    .align(Alignment.Center)
            )
            IconButton(
                onClick = {
                    if (count == 0) navController.navigate("start") else viewModel.decrement()
                },
                modifier = Modifier
                    .size(30.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back Button",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Crossfade(
                targetState = progressValue.images
            ) {
                currentImage ->
                Image(
                    painter = painterResource(id = currentImage),
                    contentDescription = "Logo Landing 1",
                    modifier = Modifier
                        .size(250.dp)
                        .clip(RoundedCornerShape(250.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .size(50.dp)
            ) {
                for (i in 1..3) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(dotColor(i, count))
                    )
                }
            }
        }

        Column (
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Crossfade(
                targetState = progressValue.title
            ) {
                currentTitle ->
                Text(
                    currentTitle,
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 32.sp
                    )
                )
            }
            Crossfade(
                targetState = progressValue.description
            ) {
                currentDescription ->
                Text(
                    currentDescription,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Gray,
                        textAlign = TextAlign.Justify
                    )
                )
            }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        if (count == 2) navController.navigate("auth/register") else viewModel.increment()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.main_color),
                        contentColor = Color.White
                    )
                ) {
                    if (count == 2) {
                        Text(
                            "Daftar"
                        )
                    } else {
                        Text(
                            "Selanjutnya"
                        )
                    }
                }
                if (count == 2) {
                    Spacer(
                        modifier = Modifier
                            .height(5.dp)
                    )
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(
                            "Sudah memiliki akun?",
                            style = TextStyle(
                                fontSize = 12.sp
                            )
                        )
                        Text(
                            "Masuk",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = colorResource(R.color.main_color)
                            ),
                            modifier = Modifier.clickable {
                                navController.navigate("auth/login")
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun dotColor(position: Int, count: Int): Color {
    val activePosition = ((count) % 3) + 1
    return if (position == activePosition)
        colorResource(id = R.color.main_color)
    else
        colorResource(id = R.color.gray_light)
}

@Preview
@Composable
fun Preview() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.main_color),
                contentColor = Color.White
            )
        ) {
            Text(
                "Selanjutnya"
            )
        }
    }
}