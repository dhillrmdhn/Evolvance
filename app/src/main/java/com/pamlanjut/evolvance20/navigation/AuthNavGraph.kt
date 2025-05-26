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
import com.pamlanjut.evolvance20.view.authentication.LoginScreen
import com.pamlanjut.evolvance20.view.authentication.RegisterOtpScreen
import com.pamlanjut.evolvance20.view.authentication.RegisterScreen
import com.pamlanjut.evolvance20.view.authentication.RegisterTnCScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = "auth/login",
        route = "auth"
    ) {
        composable("auth/register") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("auth")
            }
            val authViewModel: AuthenticationViewModel = hiltViewModel(parentEntry)

            RegisterScreen(
                viewModel = authViewModel,
                tncNavigate = {
                    navController.navigate("auth/register-tnc")
                },
                navController = navController
            )
        }

        composable("auth/register-tnc") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("auth")
            }
            val authViewModel: AuthenticationViewModel = hiltViewModel(parentEntry)

            RegisterTnCScreen(viewModel = authViewModel, navController = navController)
        }

        composable("auth/register-otp") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("auth")
            }
            val authViewModel: AuthenticationViewModel = hiltViewModel(parentEntry)

            RegisterOtpScreen(
                viewModel = authViewModel,
                navController = navController
            )
        }

        composable("auth/login") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("auth")
            }
            val authViewModel: AuthenticationViewModel = hiltViewModel(parentEntry)

            LoginScreen(
                viewModel = authViewModel,
                navController = navController
            )
        }
    }
}