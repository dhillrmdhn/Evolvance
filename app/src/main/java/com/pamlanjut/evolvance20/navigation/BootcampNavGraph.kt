package com.pamlanjut.evolvance20.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pamlanjut.evolvance20.view.bootcamp.BootcampScreen

fun NavGraphBuilder.bootcampNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = "bootcamp/index",
        route = "bootcamp"
    ) {
        composable("bootcamp/index") {
            BootcampScreen()
        }
    }
}