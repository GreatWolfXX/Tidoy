package com.greatwolf.tidoy.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
            HomeScreen()
        }
    }
}
val NavHostController.canGoBack: Boolean
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED