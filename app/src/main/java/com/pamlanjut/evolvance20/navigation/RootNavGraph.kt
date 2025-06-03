package com.pamlanjut.evolvance20.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pamlanjut.evolvance20.view.checker.CheckerScreen
import com.pamlanjut.evolvance20.view.components.LoadingScreen
import com.pamlanjut.evolvance20.view.mentoring.MentoringScreen
import com.pamlanjut.evolvance20.view.notifikasi.NotifikasiScreen

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
        checkoutNavGraph(navController)
        mentoringNavGraph(navController)

        // Composable Dummy
        composable("cvscooring") {
            LoadingScreen()
        }

        composable("career") {
            LoadingScreen()
        }

        composable("feedback") {
            LoadingScreen()
        }

        composable("notification") {
            NotifikasiScreen(navController)
        }
    }
}