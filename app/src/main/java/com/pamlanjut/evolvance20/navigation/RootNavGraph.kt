package com.pamlanjut.evolvance20.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pamlanjut.evolvance20.view.checker.CheckerScreen
import com.pamlanjut.evolvance20.view.components.LoadingScreen

@Composable
fun RootNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("checker") {
            CheckerScreen(navController)
        }

        landingNavGraph(navController)
        authNavGraph(navController)
        homeNavGraph(navController)
        bootcampNavGraph(navController)

        // Composable Dummy
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