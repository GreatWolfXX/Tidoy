package com.greatwolf.tidoy.presentation.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import com.greatwolf.tidoy.ui.theme.SwitchBackgroundOff
import com.greatwolf.tidoy.ui.theme.SwitchBackgroundOn
import kotlinx.coroutines.launch

@Composable
fun CustomSwitch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier
            .width(51.dp)
            .height(31.dp)
            .background(
                color = if (checked) SwitchBackgroundOn else SwitchBackgroundOff,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    onCheckedChange?.invoke(checked)
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if(!checked) Arrangement.Start else Arrangement.End
    ) {
        Box(
            modifier = Modifier
                .animatePlacement()
                .padding(horizontal = 2.dp)
                .size(27.dp)
                .shadow(
                    elevation = 1.dp,
                    shape = CircleShape,
                )
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
        )
    }
}

fun Modifier.animatePlacement(): Modifier = composed {
    val scope = rememberCoroutineScope()
    var targetOffset by remember { mutableStateOf(IntOffset.Zero) }
    var animatable by remember {
        mutableStateOf<Animatable<IntOffset, AnimationVector2D>?>(null)
    }
    this
        .onPlaced {
            targetOffset = it
                .positionInParent()
                .round()
        }
        .offset {
            val anim = animatable ?: Animatable(targetOffset, IntOffset.VectorConverter)
                .also {
                    animatable = it
                }


            if (anim.targetValue != targetOffset) {
                scope.launch {
                    anim.animateTo(targetOffset, spring(stiffness = Spring.StiffnessMediumLow))
                }
            }
            animatable?.let { it.value - targetOffset } ?: IntOffset.Zero
        }
}

@Preview(showBackground = true)
@Composable
fun CustomSwitchPreview() {
    var checked by remember { mutableStateOf(false) }
    CustomSwitch(
        checked = checked,
        onCheckedChange = {
            checked = !checked
        }
    )
}