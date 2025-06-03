package com.pamlanjut.evolvance20.navigation

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.pamlanjut.evolvance20.view.bootcamp.DetailContentBootcamp
import com.pamlanjut.evolvance20.view.checkout.CheckoutScreen
import com.pamlanjut.evolvance20.view.checkout.CheckoutStatus
import com.pamlanjut.evolvance20.view.checkout.CheckoutViewModel

fun NavGraphBuilder.checkoutNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = "checkout/index",
        route = "checkout"
    ) {
        composable(
            route = "checkout/index/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("checkout")
            }
            val viewModel: CheckoutViewModel = hiltViewModel(parentEntry)
            val id = backStackEntry.arguments?.getInt("id") ?: return@composable

            CheckoutScreen(viewModel, id, navController)
        }

        composable(
            route = "checkout/detail",
        ) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("checkout")
            }
            val viewModel: CheckoutViewModel = hiltViewModel(parentEntry)

            CheckoutStatus(viewModel, navController)
        }
    }
}