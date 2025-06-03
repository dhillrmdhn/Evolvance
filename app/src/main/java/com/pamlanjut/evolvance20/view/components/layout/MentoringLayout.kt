package com.pamlanjut.evolvance20.view.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.pamlanjut.evolvance20.view.mentoring.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MentoringLayout(
    content: @Composable () -> Unit,
    withPrice: Boolean? = false
) {
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
                    TopBar(
                        withPrice ?: false
                    )
                }

                item {
                    content()
                }
            }
        }
    }
}