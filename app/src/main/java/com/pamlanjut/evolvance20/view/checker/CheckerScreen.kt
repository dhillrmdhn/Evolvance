package com.pamlanjut.evolvance20.view.checker

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pamlanjut.evolvance20.view.components.LoadingScreen
import kotlinx.coroutines.delay

@Composable
fun CheckerScreen(
    navController: NavController,
    viewModel: CheckerViewModel = hiltViewModel()
) {
    val isLogin by viewModel.isLoggedIn.collectAsState()
    LaunchedEffect(isLogin) {
        navController.navigate(
            if (isLogin) "bootcamp" else "landing"
        ) {
            popUpTo("checker") { inclusive = true }
        }
    }

    Box(
        Modifier.fillMaxSize()
    ) {
        LoadingScreen()
    }
}