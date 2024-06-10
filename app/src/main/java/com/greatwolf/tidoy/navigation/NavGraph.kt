package com.greatwolf.tidoy.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: Screen = Screen.Splash
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Screen.Splash> {

        }
    }
}
val NavHostController.canGoBack: Boolean
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED