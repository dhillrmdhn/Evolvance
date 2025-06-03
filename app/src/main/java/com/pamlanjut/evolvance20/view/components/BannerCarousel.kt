package com.pamlanjut.evolvance20.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.pamlanjut.evolvance20.R
import kotlinx.coroutines.launch

@Composable
fun BannerCarousel(
    imageList: List<Int>,
    modifier: Modifier = Modifier,
    imageHeight: Dp = 200.dp
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { imageList.size }
    )

    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(imageHeight)
            .clip(RoundedCornerShape(16.dp))
    ) {
        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fill,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Image(
                painter = painterResource(imageList[page]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Box(
            modifier = Modifier
                .padding(start = 12.dp)
                .size(36.dp)
                .clip(CircleShape)
                .align(Alignment.CenterStart)
                .background(Color.White.copy(alpha = 0.9f))
                .clickable {
                    coroutineScope.launch {
                        val prev = (pagerState.currentPage - 1).coerceAtLeast(0)
                        pagerState.animateScrollToPage(prev)
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft,
                contentDescription = "Previous",
                tint = colorResource(R.color.main_color),
                modifier = Modifier.size(28.dp)
            )
        }

        Box(
            modifier = Modifier
                .padding(end = 12.dp)
                .size(36.dp)
                .clip(CircleShape)
                .align(Alignment.CenterEnd)
                .background(Color.White.copy(alpha = 0.9f))
                .clickable {
                    coroutineScope.launch {
                        val next = (pagerState.currentPage + 1).coerceAtMost(imageList.size - 1)
                        pagerState.animateScrollToPage(next)
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "Next",
                tint = colorResource(R.color.main_color),
                modifier = Modifier.size(28.dp)
            )
        }
    }
}