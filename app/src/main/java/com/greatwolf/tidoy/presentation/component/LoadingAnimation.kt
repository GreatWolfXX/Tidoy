package com.greatwolf.tidoy.presentation.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun LoadingAnimation() {
    Box {
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val angle by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(2000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            ), label = ""
        )

        Canvas(
            modifier = Modifier
                .align(Alignment.Center)
                .size(32.dp)
        ) {
            drawCircle(
                color = Color.White,
                alpha = 0.4f,
                style = Stroke(width = 8f)
            )
        }

        Canvas(
            modifier = Modifier
                .align(Alignment.Center)
                .size(32.dp)
        ) {
            drawArc(
                color = Color.White,
                style = Stroke(
                    width = 8f,
                    cap = StrokeCap.Round,
                    join = StrokeJoin.Round
                ),
                startAngle = angle,
                sweepAngle = 360 / 5f,
                useCenter = false
            )
        }
    }
}