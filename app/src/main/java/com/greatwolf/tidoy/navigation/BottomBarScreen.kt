package com.greatwolf.tidoy.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.greatwolf.tidoy.R

sealed class BottomBarScreen(
    val screen: Screen,
    @StringRes
    val title: Int,
    @DrawableRes
    val icon: Int,
    @DrawableRes
    val iconSelected: Int
) {
    data object Discovery: BottomBarScreen(
        screen = Screen.Discovery,
        title = R.string.bottom_navigation_discovery,
        icon = R.drawable.discovery_icon,
        iconSelected = R.drawable.discovery_selected_icon
    )

    data object Wishlist: BottomBarScreen(
        screen = Screen.Wishlist,
        title = R.string.bottom_navigation_wishlist,
        icon = R.drawable.wishlist_icon,
        iconSelected = R.drawable.wishlist_selected_icon
    )

    data object Stay: BottomBarScreen(
        screen = Screen.Stay,
        title = R.string.bottom_navigation_stay,
        icon = R.drawable.stay_icon,
        iconSelected = R.drawable.stay_selected_icon
    )

    data object Profile: BottomBarScreen(
        screen = Screen.Profile,
        title = R.string.bottom_navigation_profile,
        icon = R.drawable.profile_icon,
        iconSelected = R.drawable.profile_selected_icon
    )
}