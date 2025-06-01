package com.pamlanjut.evolvance20.navigation

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.pamlanjut.evolvance20.view.bootcamp.BootcampScreen
import com.pamlanjut.evolvance20.view.bootcamp.BootcampViewModel
import com.pamlanjut.evolvance20.view.bootcamp.DetailContentBootcamp
import com.pamlanjut.evolvance20.view.bootcamp.DetailRegisterBootcampScreen

fun NavGraphBuilder.bootcampNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = "bootcamp/index",
        route = "bootcamp"
    ) {
        composable("bootcamp/index") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("bootcamp")
            }
            val viewModel: BootcampViewModel = hiltViewModel(parentEntry)

            BootcampScreen(viewModel, navController)
        }

        composable(
            route = "bootcamp/detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("bootcamp")
            }
            val viewModel: BootcampViewModel = hiltViewModel(parentEntry)
            val id = backStackEntry.arguments?.getInt("id") ?: return@composable

            DetailRegisterBootcampScreen(id, viewModel)
        }

        composable(
            route = "bootcamp/content/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("bootcamp")
            }
            val viewModel: BootcampViewModel = hiltViewModel(parentEntry)
            val id = backStackEntry.arguments?.getInt("id") ?: return@composable

            DetailContentBootcamp(id, viewModel)
        }
    }
}