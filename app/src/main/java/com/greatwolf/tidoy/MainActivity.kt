package com.greatwolf.tidoy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.greatwolf.tidoy.navigation.Screen
import com.greatwolf.tidoy.navigation.SetupNavGraph
import com.greatwolf.tidoy.ui.theme.Neutral100
import com.greatwolf.tidoy.ui.theme.TidoyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TidoyTheme {
                val containerColor = if(isSystemInDarkTheme()) Neutral100 else Color.White
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = containerColor
                ) { paddingValues ->
                    val navController = rememberNavController()
                    SetupNavGraph(
                        paddingValues = paddingValues,
                        navController = navController
                    )
                }
            }
        }
    }
}