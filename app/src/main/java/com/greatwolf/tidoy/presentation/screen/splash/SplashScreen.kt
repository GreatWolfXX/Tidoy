package com.greatwolf.tidoy.presentation.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.greatwolf.tidoy.R
import com.greatwolf.tidoy.presentation.component.LoadingAnimation
import com.greatwolf.tidoy.ui.theme.BackgroundMain
import com.greatwolf.tidoy.ui.theme.SecondarySplash
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    var startAnimation by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(2500)
        navController.popBackStack()
        navController.navigate(viewModel.startDestination.value)
    }
    Splash()
}

@Composable
fun Splash() {
    val gradient = Brush.verticalGradient(
        colorStops = arrayOf(
            0.65f to BackgroundMain,
            1f to SecondarySplash
        )
    )
    Box(
        modifier = Modifier
            .background(gradient)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            imageVector = ImageVector.vectorResource(id = R.drawable.tidoy_logo),
            contentDescription = null
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoadingAnimation()
            Spacer(modifier = Modifier.size(64.dp))
            Image(
                modifier = Modifier.align(Alignment.Start),
                imageVector = ImageVector.vectorResource(id = R.drawable.splash_stars),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    Splash()
}