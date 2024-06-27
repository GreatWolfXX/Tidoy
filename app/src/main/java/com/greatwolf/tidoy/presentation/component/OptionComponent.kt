package com.greatwolf.tidoy.presentation.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.tidoy.R
import com.greatwolf.tidoy.ui.theme.InfoMain
import com.greatwolf.tidoy.ui.theme.Neutral100
import com.greatwolf.tidoy.ui.theme.Neutral50
import com.greatwolf.tidoy.ui.theme.manropeFontFamily

enum class OptionComponentStyle {
    DEFAULT,
    CHECKBOX,
    RADIOBUTTON
}

@Composable
fun OptionComponent(
    @StringRes
    text: Int,
    style: OptionComponentStyle = OptionComponentStyle.DEFAULT
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = stringResource(id = text),
            color = if(isSystemInDarkTheme()) Color.White else Neutral100,
            fontSize = 16.sp,
            fontFamily = manropeFontFamily
        )
        var isSelected by remember { mutableStateOf(false) }
        when(style) {
            OptionComponentStyle.DEFAULT -> {

            }
            OptionComponentStyle.CHECKBOX -> {

            }
            OptionComponentStyle.RADIOBUTTON -> {
                RadioButton(
                    selected = isSelected,
                    onClick = {
                        isSelected = !isSelected
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = InfoMain,
                        unselectedColor = Neutral50
                    )
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun OptionComponentPreview() {
    OptionComponent(
        text = R.string.title_logout,
        style = OptionComponentStyle.RADIOBUTTON
    )
}