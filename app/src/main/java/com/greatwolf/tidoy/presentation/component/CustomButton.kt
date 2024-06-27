package com.greatwolf.tidoy.presentation.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.tidoy.R
import com.greatwolf.tidoy.ui.theme.Neutral100
import com.greatwolf.tidoy.ui.theme.Neutral40
import com.greatwolf.tidoy.ui.theme.Neutral50
import com.greatwolf.tidoy.ui.theme.Neutral70
import com.greatwolf.tidoy.ui.theme.PrimaryMain
import com.greatwolf.tidoy.ui.theme.manropeFontFamily

enum class CustomButtonStyle {
    PRIMARY,
    SECONDARY
}

@Composable
fun CustomButton(
    modifier: Modifier = Modifier.fillMaxWidth(),
    @StringRes
    text: Int,
    @DrawableRes
    iconStart: Int = -1,
    @DrawableRes
    iconEnd: Int = -1,
    textPaddingValues: PaddingValues = PaddingValues(vertical = 18.dp),
    textFontSize: TextUnit = 14.sp,
    cornerRadius: Dp = 16.dp,
    customBackgroundColor: Color = Color.Black,
    style: CustomButtonStyle = CustomButtonStyle.PRIMARY,
    onClick: () -> Unit
) {
    val contentColor = when(style) {
        CustomButtonStyle.PRIMARY -> Color.White
        CustomButtonStyle.SECONDARY -> if(isSystemInDarkTheme()) Color.White else Neutral100
    }

    var backgroundColor = when(style) {
        CustomButtonStyle.PRIMARY -> PrimaryMain
        CustomButtonStyle.SECONDARY -> Color.Transparent
    }
    if(customBackgroundColor != Color.Black) {
        backgroundColor = customBackgroundColor
    }

    val borderColor = when(style) {
        CustomButtonStyle.PRIMARY -> Color.Transparent
        CustomButtonStyle.SECONDARY -> if(isSystemInDarkTheme()) Neutral70 else Neutral40
    }

    Button(
        modifier = modifier,
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonColors(
            containerColor = backgroundColor,
            contentColor = contentColor,
            disabledContainerColor = contentColor,
            disabledContentColor = Neutral50
        ),
        border = BorderStroke(1.dp, borderColor),
        contentPadding = PaddingValues(),
        onClick = onClick,
    ) {
        if(iconStart != -1) {
            Icon(
                imageVector = ImageVector.vectorResource(id = iconStart),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            modifier = Modifier.padding(textPaddingValues),
            text = stringResource(id = text),
            fontSize = textFontSize,
            fontWeight = FontWeight.Bold,
            fontFamily = manropeFontFamily
        )
        Spacer(modifier = Modifier.size(8.dp))
        if(iconEnd != -1) {
            Icon(
                imageVector = ImageVector.vectorResource(id = iconEnd),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    CustomButton(
        text = R.string.btn_next,
        iconEnd = R.drawable.arrow_forward
    ) {

    }
}