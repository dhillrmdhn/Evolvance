package com.pamlanjut.evolvance20.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pamlanjut.evolvance20.view.home.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = "home/index",
        route = "home"
    ) {
        composable("home/index") {
            HomeScreen(
                navController
            )
        }
    }
}