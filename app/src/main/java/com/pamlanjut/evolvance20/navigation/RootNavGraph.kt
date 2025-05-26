package com.pamlanjut.evolvance20.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pamlanjut.evolvance20.view.checker.CheckerScreen

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
    }
}