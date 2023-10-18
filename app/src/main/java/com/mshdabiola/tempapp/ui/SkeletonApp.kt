package com.mshdabiola.tempapp.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import com.mshdabiola.designsystem.theme.SkeletonAppTheme
import com.mshdabiola.tempapp.navigation.SkeletonAppNavHost

@Composable
fun SkeletonApp(
    windowSizeClass: WindowSizeClass,
    noteAppState: SkeletonAppState = rememberSkeletonAppState(windowSizeClass = windowSizeClass),
) {
    SkeletonAppTheme {
        SkeletonAppNavHost(navController = noteAppState.navHostController)
    }
}
