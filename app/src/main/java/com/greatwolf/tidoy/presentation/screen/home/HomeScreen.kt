package com.greatwolf.tidoy.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .background(Color.Yellow)
            .fillMaxSize()
    ) {
        Text(
            text = "Home Screen"
        )
    }
}