package com.pamlanjut.evolvance20.view.notifikasi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pamlanjut.evolvance20.view.components.layout.MainLayout
import com.pamlanjut.evolvance20.view.notifikasi.components.NotificationCard

@Composable
fun NotifikasiScreen(
    navController: NavController
) {
    MainLayout(
        content = {
            LazyColumn(
                Modifier.fillMaxSize().padding(18.dp, 24.dp ),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(5) {
                    NotificationCard()
                }
            }
        },
        showBottomBar = true,
        navController
    )
}