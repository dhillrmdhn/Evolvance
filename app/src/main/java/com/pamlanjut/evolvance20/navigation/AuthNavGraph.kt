package com.pamlanjut.evolvance20.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pamlanjut.evolvance20.view.authentication.AuthenticationViewModel
import com.pamlanjut.evolvance20.view.authentication.RegisterOtpScreen
import com.pamlanjut.evolvance20.view.authentication.RegisterScreen
import com.pamlanjut.evolvance20.view.authentication.RegisterTnCScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = "register-otp",
        route = "auth"
    ) {

        composable("register") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("auth")
            }
            val authViewModel: AuthenticationViewModel = hiltViewModel(parentEntry)

            RegisterScreen(
                viewModel = authViewModel,
                tncNavigate = {
                    navController.navigate("register-tnc")
                },
                navController = navController
            )
        }

        composable("register-tnc") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("auth")
            }
            val authViewModel: AuthenticationViewModel = hiltViewModel(parentEntry)

            RegisterTnCScreen(viewModel = authViewModel, navController = navController)
        }

        composable("register-otp") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("auth")
            }
            val authViewModel: AuthenticationViewModel = hiltViewModel(parentEntry)

            RegisterOtpScreen(
                viewModel = authViewModel
            )
        }
    }
}