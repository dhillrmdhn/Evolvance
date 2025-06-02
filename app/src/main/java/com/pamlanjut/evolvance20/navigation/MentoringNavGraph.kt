package com.pamlanjut.evolvance20.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pamlanjut.evolvance20.view.bootcamp.BootcampViewModel
import com.pamlanjut.evolvance20.view.mentoring.MentoringSchedule
import com.pamlanjut.evolvance20.view.mentoring.MentoringScreen
import com.pamlanjut.evolvance20.view.mentoring.MentoringViewModel
import com.pamlanjut.evolvance20.view.mentoring.PaymentMentoring

fun NavGraphBuilder.mentoringNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = "mentoring/index",
        route = "mentoring"
    ) {
        composable("mentoring/index") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("mentoring")
            }
            val viewModel: MentoringViewModel = hiltViewModel(parentEntry)

            MentoringScreen(navController, viewModel)
        }

        composable("mentoring/detail") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("mentoring")
            }
            val viewModel: MentoringViewModel = hiltViewModel(parentEntry)

            MentoringSchedule(navController, viewModel)
        }

        composable("mentoring/payment") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("mentoring")
            }
            val viewModel: MentoringViewModel = hiltViewModel(parentEntry)

            PaymentMentoring(viewModel)
        }
    }
}