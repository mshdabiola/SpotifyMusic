package com.mshdabiola.mainscreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val mainNavigationRoute = "main_route"

const val mainRoute = "main_route"

fun NavGraphBuilder.mainScreen(onBack: () -> Unit) {
    composable(
        route = mainRoute,
    ) {
        MainScreen(onBack = onBack)
    }
}

fun NavController.navigateToMain() {
    navigate(route = mainRoute)
}
