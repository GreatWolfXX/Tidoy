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
}