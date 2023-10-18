package com.mshdabiola.tempapp.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class SkeletonAppState(
    val windowSizeClass: WindowSizeClass,
    val navHostController: NavHostController,
)

@Composable
fun rememberSkeletonAppState(
    windowSizeClass: WindowSizeClass,
    navHostController: NavHostController = rememberNavController(),
): SkeletonAppState {
    return remember(key1 = windowSizeClass) {
        SkeletonAppState(windowSizeClass, navHostController)
    }
}
