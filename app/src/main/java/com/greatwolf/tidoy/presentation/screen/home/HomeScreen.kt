package com.greatwolf.tidoy.presentation.screen.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.greatwolf.tidoy.navigation.BottomBarScreen
import com.greatwolf.tidoy.navigation.BottomNavGraph
import com.greatwolf.tidoy.navigation.Screen
import com.greatwolf.tidoy.ui.theme.Neutral100
import com.greatwolf.tidoy.ui.theme.Neutral20
import com.greatwolf.tidoy.ui.theme.Neutral60
import com.greatwolf.tidoy.ui.theme.Neutral80
import com.greatwolf.tidoy.ui.theme.Neutral90
import com.greatwolf.tidoy.ui.theme.PrimarySurface
import com.greatwolf.tidoy.ui.theme.Text80Dark
import com.greatwolf.tidoy.ui.theme.manropeFontFamily

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { paddingValues ->
        BottomNavGraph(
            paddingValues = paddingValues,
            navController = navController
        )
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Discovery,
        BottomBarScreen.Wishlist,
        BottomBarScreen.Stay,
        BottomBarScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = navBackStackEntry.fromRoute()
    val colorTopBorder = if(isSystemInDarkTheme()) Color.White else Neutral20
    NavigationBar(
        modifier = Modifier
            .drawBehind {
                val borderSize = 1.dp.toPx()
                drawLine(
                    color = colorTopBorder,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = borderSize
                )
            },
        containerColor = if(isSystemInDarkTheme()) Neutral100 else Color.White
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentScreen = currentScreen,
                navController = navController
            )
        }
    }
}

fun NavBackStackEntry?.fromRoute(): Screen {
    this?.destination?.route?.substringBefore("?")?.substringBefore("/")
        ?.substringAfterLast(".")?.let {
            when (it) {
                Screen.Discovery::class.simpleName -> return Screen.Discovery
                Screen.Wishlist::class.simpleName -> return Screen.Wishlist
                Screen.Stay::class.simpleName -> return Screen.Stay
                Screen.Profile::class.simpleName -> return Screen.Profile
                else -> return Screen.Discovery
            }
        }
    return Screen.Home
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentScreen: Screen,
    navController: NavHostController
) {
    val isSelected = currentScreen == screen.screen
    val icon = if(isSelected) screen.iconSelected else screen.icon
    NavigationBarItem(
        icon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = icon),
                contentDescription = null,
            )
        },
        label = {
            Text(
                text = stringResource(id = screen.title),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = manropeFontFamily
            )
        },
        selected = isSelected,
        onClick = {
            navController.navigate(screen.screen)
        },
        colors = NavigationBarItemColors(
            selectedIconColor = Color.Unspecified,
            selectedTextColor = if(isSystemInDarkTheme()) Color.White else Neutral100,
            selectedIndicatorColor = PrimarySurface,
            unselectedIconColor = if(isSystemInDarkTheme()) Neutral20 else Neutral90,
            unselectedTextColor = if(isSystemInDarkTheme()) Text80Dark else Neutral80,
            disabledIconColor = Neutral60,
            disabledTextColor = Neutral60
        )
    )
}