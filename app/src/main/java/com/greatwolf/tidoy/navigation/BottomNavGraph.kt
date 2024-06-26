package com.greatwolf.tidoy.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.greatwolf.tidoy.presentation.screen.discovery.DiscoveryScreen
import com.greatwolf.tidoy.presentation.screen.profile.ProfileScreen

@Composable
fun BottomNavGraph(
    paddingValues: PaddingValues,
    navController: NavHostController
) {
    NavHost(
        modifier = Modifier.padding(paddingValues),
        navController = navController,
        startDestination = Screen.Discovery
    ) {
        composable<Screen.Discovery> {
            DiscoveryScreen()
        }
        composable<Screen.Wishlist> {

        }
        composable<Screen.Stay> {

        }
        composable<Screen.Profile> {
            ProfileScreen()
        }
    }
}