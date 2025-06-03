package com.pamlanjut.evolvance20.view.mentoring

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.pamlanjut.evolvance20.data.local.static.MentoringHistoryList
import com.pamlanjut.evolvance20.view.mentoring.components.MentoringHistoryCard

@Composable
fun MentoringHistoryScreen(
    navController: NavController,
    viewModel: MentoringViewModel
) {
    LazyColumn(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(MentoringHistoryList.size) { index ->
            MentoringHistoryCard(
                MentoringHistoryList[index],
                viewModel,
                navController
            )
        }
    }
}