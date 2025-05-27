package com.pamlanjut.evolvance20.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

fun NavGraphBuilder.bootcampNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = "bootcamp/index",
        route = "bootcamp"
    ) {

    }
}