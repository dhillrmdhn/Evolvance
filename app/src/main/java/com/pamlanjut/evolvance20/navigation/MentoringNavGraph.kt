package com.pamlanjut.evolvance20.navigation

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pamlanjut.evolvance20.view.mentoring.MentoringScreen
import com.pamlanjut.evolvance20.view.mentoring.ScreenLayout

fun NavGraphBuilder.mentoringNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = "mentoring/index",
        route = "mentoring"
    ) {
        composable("mentoring/index") {
            MentoringScreen()
        }
    }
}