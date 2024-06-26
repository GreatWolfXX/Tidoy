package com.greatwolf.tidoy.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.greatwolf.tidoy.presentation.screen.home.HomeScreen
import com.greatwolf.tidoy.presentation.screen.splash.SplashScreen
import com.greatwolf.tidoy.presentation.screen.welcome.WelcomeScreen

@Composable
fun SetupNavGraph(
    paddingValues: PaddingValues,
    navController: NavHostController,
    startDestination: Screen = Screen.Splash
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Screen.Splash> {
            SplashScreen(navController = navController)
        }
        composable<Screen.Welcome> {
            WelcomeScreen(
                paddingValues = paddingValues,
                navController = navController
            )
        }
        composable<Screen.Home> {
            HomeScreen(
                paddingValues = paddingValues
            )
        }
    }
}
val NavHostController.canGoBack: Boolean
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED