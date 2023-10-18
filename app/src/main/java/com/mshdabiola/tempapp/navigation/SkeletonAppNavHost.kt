package com.mshdabiola.tempapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mshdabiola.mainscreen.mainNavigationRoute
import com.mshdabiola.mainscreen.mainScreen

@Composable
fun SkeletonAppNavHost(
    navController: NavHostController,
    startDestination: String = mainNavigationRoute,
) {
    NavHost(navController = navController, startDestination = startDestination) {
        mainScreen(onBack = {})
    }
}
