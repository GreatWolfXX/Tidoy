package com.greatwolf.tidoy.presentation.screen.profile

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.tidoy.R
import com.greatwolf.tidoy.ui.theme.Neutral100
import com.greatwolf.tidoy.ui.theme.SwitchBackgroundOff
import com.greatwolf.tidoy.ui.theme.SwitchBackgroundOn
import com.greatwolf.tidoy.ui.theme.manropeFontFamily

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        GeneralInfo()
    }
}

@Composable
fun  Header() {
    Spacer(modifier = Modifier.size(12.dp))
    Image(
        modifier = Modifier.size(80.dp),
        painter = painterResource(id = R.drawable.profile_img),
        contentDescription = null
    )
    Spacer(modifier = Modifier.size(12.dp))
    Text(
        text = "John Doe", //Testing field
        color = if(isSystemInDarkTheme()) Color.White else Neutral100,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = manropeFontFamily,
        textAlign = TextAlign.Start
    )
    Text(
        text = "johndoe@gmail.com", //Testing field
        color = if(isSystemInDarkTheme()) Color.White else Neutral100,
        fontSize = 12.sp,
        fontFamily = manropeFontFamily,
        textAlign = TextAlign.Start
    )
    Spacer(modifier = Modifier.size(12.dp))
}

@Composable
fun GeneralInfo() {
    Spacer(modifier = Modifier.size(12.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = stringResource(id = R.string.title_general),
            color = if(isSystemInDarkTheme()) Color.White else Neutral100,
            fontSize = 14.sp,
            fontFamily = manropeFontFamily,
            textAlign = TextAlign.Start
        )
        ProfileMenuItem(
            icon = R.drawable.edit_profile_icon,
            text = R.string.title_edit_profile
        )
        Spacer(modifier = Modifier.size(4.dp))
        ProfileMenuItem(
            icon = R.drawable.language_icon,
            text = R.string.title_language
        )
        Spacer(modifier = Modifier.size(4.dp))
        ProfileMenuItem(
            icon = R.drawable.night_icon,
            text = R.string.title_dark_mode,
            style = ProfileMenuItemStyle.SWITCH
        )
    }
    Spacer(modifier = Modifier.size(16.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = stringResource(id = R.string.title_preferences),
            color = if(isSystemInDarkTheme()) Color.White else Neutral100,
            fontSize = 14.sp,
            fontFamily = manropeFontFamily,
            textAlign = TextAlign.Start
        )
        ProfileMenuItem(
            icon = R.drawable.legal_icon,
            text = R.string.title_legal
        )
        Spacer(modifier = Modifier.size(4.dp))
        ProfileMenuItem(
            icon = R.drawable.help_icon,
            text = R.string.title_help
        )
        Spacer(modifier = Modifier.size(4.dp))
        ProfileMenuItem(
            icon = R.drawable.exit_icon,
            text = R.string.title_logout
        )
    }
}

enum class ProfileMenuItemStyle {
    BASIC,
    SWITCH
}

@Composable
fun ProfileMenuItem(
    @DrawableRes
    icon: Int,
    @StringRes
    text: Int,
    style: ProfileMenuItemStyle = ProfileMenuItemStyle.BASIC
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            modifier = Modifier.weight(1f),
            text = stringResource(id = text),
            color = if(isSystemInDarkTheme()) Color.White else Neutral100,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = manropeFontFamily,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.size(8.dp))
        when(style) {
            ProfileMenuItemStyle.BASIC -> {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_icon),
                    contentDescription = null
                )
            }
            ProfileMenuItemStyle.SWITCH -> {
                var checked by remember { mutableStateOf(false) }
                // Need create custom switch
                Switch(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    },
                    colors = SwitchDefaults.colors(
                        checkedBorderColor = Color.Transparent,
                        uncheckedBorderColor = Color.Transparent,
                        checkedTrackColor = SwitchBackgroundOn,
                        uncheckedTrackColor = SwitchBackgroundOff,
                        checkedThumbColor = Color.White,
                        uncheckedThumbColor = Color.White
                    )
                )
            }
        }
    }
}