package com.pamlanjut.evolvance20.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pamlanjut.evolvance20.view.landing.LandingScreen
import com.pamlanjut.evolvance20.view.landing.LandingViewModel
import com.pamlanjut.evolvance20.view.landing.StartScreen

fun NavGraphBuilder.landingNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = "start",
        route = "landing"
    ) {
        composable("start") {
            StartScreen(
                onStart = {
                    navController.navigate("start-2")
                }
            )
        }

        composable("start-2") {
            val viewModel = hiltViewModel<LandingViewModel>()
            LandingScreen(viewModel = viewModel)
        }
    }
}
