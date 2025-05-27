package com.pamlanjut.evolvance20.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pamlanjut.evolvance20.view.checker.CheckerScreen
import com.pamlanjut.evolvance20.view.components.LoadingScreen

@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "checker"
    ) {
        composable("checker") {
            CheckerScreen(navController)
        }

        landingNavGraph(navController = navController)
        authNavGraph(navController = navController)
        homeNavGraph(navController = navController)

        // Composable
        composable("bootcamp") {
            LoadingScreen()
        }

        composable("mentoring") {
            LoadingScreen()
        }

        composable("cvscooring") {
            LoadingScreen()
        }

        composable("career") {
            LoadingScreen()
        }

        composable("feedback") {
            LoadingScreen()
        }
    }
}