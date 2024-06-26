package com.greatwolf.tidoy.navigation

import kotlinx.serialization.Serializable


@Serializable
sealed class Screen {
    @Serializable
    data object Splash: Screen()
    @Serializable
    data object Welcome: Screen()
    @Serializable
    data object Home: Screen()
    @Serializable
    data object Discovery: Screen()
    @Serializable
    data object Wishlist: Screen()
    @Serializable
    data object Stay: Screen()
    @Serializable
    data object Profile: Screen()
}