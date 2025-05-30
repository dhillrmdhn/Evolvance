package com.pamlanjut.evolvance20.view.components.layout

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.view.bootcamp.DetailRegisterBootcampScreen
import com.pamlanjut.evolvance20.view.bootcamp.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BootcampLayout(
    content: @Composable () -> Unit
) {
    val scrollState = rememberLazyListState()
    val density = LocalDensity.current

    val headerHeightPx = with(density) { 280.dp.toPx() }
    val showTitleInAppBar by remember {
        derivedStateOf {
            val index = scrollState.firstVisibleItemIndex
            val offset = scrollState.firstVisibleItemScrollOffset
            index > 0 || offset > headerHeightPx.toInt()
        }
    }

    Box(
        Modifier.fillMaxSize()
    ) {
        //Scaffold
        Scaffold(
            containerColor = Color.Transparent,
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentPadding = innerPadding
            ) {
                item {
                    TopBar()
                }

                item {
                    content()
                }
            }
        }
    }
}