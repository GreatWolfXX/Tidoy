package com.greatwolf.tidoy.presentation.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.tidoy.R
import com.greatwolf.tidoy.ui.theme.BackgroundDanger
import com.greatwolf.tidoy.ui.theme.Neutral100
import com.greatwolf.tidoy.ui.theme.Neutral40
import com.greatwolf.tidoy.ui.theme.Neutral60
import com.greatwolf.tidoy.ui.theme.Neutral70
import com.greatwolf.tidoy.ui.theme.Neutral90
import com.greatwolf.tidoy.ui.theme.StrokeFocused
import com.greatwolf.tidoy.ui.theme.TextDanger
import com.greatwolf.tidoy.ui.theme.manropeFontFamily

enum class CustomTextInputStyle {
    NORMAL,
    PHONE,
    PASSWORD
}

@Composable
fun CustomTextInput(
    @StringRes
    title: Int,
    @StringRes
    placeholder: Int,
    @StringRes
    error: Int,
    @DrawableRes
    icon: Int = -1,
    isError: Boolean,
    style: CustomTextInputStyle = CustomTextInputStyle.NORMAL
) {
    val titleColor = if(isSystemInDarkTheme()) Color.White else Neutral100
    val placeholderColor = Neutral60
    val containerColor = if(isSystemInDarkTheme()) Neutral90 else Color.White
    val indicatorColor = if(isSystemInDarkTheme()) Neutral70 else Neutral40
    val textColor = if(isSystemInDarkTheme()) Color.White else Neutral100
    var passwordVisible by remember { mutableStateOf(false) }

    val visualTransformation = when(style) {
        CustomTextInputStyle.NORMAL -> VisualTransformation.None
        CustomTextInputStyle.PHONE -> VisualTransformation.None
        CustomTextInputStyle.PASSWORD -> if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    }

    val keyboardOptions = when(style) {
        CustomTextInputStyle.NORMAL -> KeyboardOptions.Default
        CustomTextInputStyle.PHONE ->  KeyboardOptions(keyboardType = KeyboardType.Phone)
        CustomTextInputStyle.PASSWORD -> KeyboardOptions(keyboardType = KeyboardType.Password)
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        var textField by remember { mutableStateOf("") }
        Text(
            modifier = Modifier.padding(bottom = 6.dp),
            text = stringResource(id = title),
            color = if(isError) TextDanger else titleColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = manropeFontFamily
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = textField,
            onValueChange = { textField = it },
            textStyle = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = manropeFontFamily
            ),
            placeholder = {
                Text(
                    text = stringResource(id = placeholder),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = manropeFontFamily
                )
            },
            suffix = {
                if(icon != -1) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = icon),
                        contentDescription = null
                    )
                }
            },
            supportingText = {
                if(isError) {
                    Row(
                        modifier = Modifier.offset(x = (-10).dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.error),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = stringResource(id = error),
                            color = TextDanger,
                            fontSize = 12.sp,
                            fontFamily = manropeFontFamily
                        )
                    }
                }
            },
            trailingIcon = if(style == CustomTextInputStyle.PASSWORD) {
                {
                    val iconVisibility = if (!passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    IconButton(onClick = {passwordVisible = !passwordVisible}) {
                        Icon(imageVector  = iconVisibility, contentDescription = null)
                    }
                }
            } else { null },
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = textColor,
                unfocusedTextColor = textColor,
                errorTextColor = TextDanger,
                focusedContainerColor = containerColor,
                unfocusedContainerColor = containerColor,
                errorContainerColor = BackgroundDanger,
                cursorColor = textColor,
                focusedIndicatorColor = StrokeFocused,
                unfocusedIndicatorColor = indicatorColor,
                errorIndicatorColor = TextDanger,
                focusedPlaceholderColor = placeholderColor,
                unfocusedPlaceholderColor = placeholderColor,
                errorPlaceholderColor = TextDanger,
                focusedSuffixColor = textColor,
                unfocusedSuffixColor = placeholderColor,
                errorSuffixColor = TextDanger
            ),
            isError = isError
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomTextInputPreview() {
    CustomTextInput(
        title = R.string.title_username,
        placeholder = R.string.placeholder_example_username,
        error = R.string.err_username_already_used,
        icon = R.drawable.credit_card,
        isError = false
    )
}