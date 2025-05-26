package com.pamlanjut.evolvance20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pamlanjut.evolvance20.navigation.RootNavGraph
import com.pamlanjut.evolvance20.ui.theme.Evolvance20Theme
import com.pamlanjut.evolvance20.view.AppViewModel
import com.pamlanjut.evolvance20.view.authentication.LoginScreen
import com.pamlanjut.evolvance20.view.authentication.RegisterScreen
import com.pamlanjut.evolvance20.view.components.LoadingScreen
import com.pamlanjut.evolvance20.view.landing.LandingScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            RootScreen(navController = navController)
        }
    }
}

@Composable
fun RootScreen(
    navController: NavHostController,
    appViewModel: AppViewModel = hiltViewModel()
) {
    val isLoading by appViewModel.isLoading.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        RootNavGraph(navController = navController)

        if (isLoading) {
            LoadingScreen()
        }
    }
}