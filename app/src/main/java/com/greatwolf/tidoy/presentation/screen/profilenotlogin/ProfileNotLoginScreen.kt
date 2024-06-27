package com.greatwolf.tidoy.presentation.screen.profilenotlogin

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.tidoy.R
import com.greatwolf.tidoy.presentation.component.CustomButton
import com.greatwolf.tidoy.presentation.component.CustomButtonStyle
import com.greatwolf.tidoy.ui.theme.Neutral100
import com.greatwolf.tidoy.ui.theme.manropeFontFamily

@Composable
fun ProfileNotLoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        GeneralInfo()
    }
}

@Composable
fun Header() {
    Icon(
        modifier = Modifier.padding(vertical = 18.dp),
        imageVector = ImageVector.vectorResource(id = R.drawable.avatar_icon),
        contentDescription = null
    )
    CustomButton(
        modifier = Modifier.wrapContentWidth(),
        text = R.string.title_login_register,
        textPaddingValues = PaddingValues(12.dp),
        cornerRadius = 8.dp,
        style = CustomButtonStyle.PRIMARY
    ) {

    }
    Spacer(modifier = Modifier.size(16.dp))
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
    }
}

@Composable
fun ProfileMenuItem(
    @DrawableRes
    icon: Int,
    @StringRes
    text: Int
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
        Icon(
            painter = painterResource(id = R.drawable.arrow_icon),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileNotLoginScreenPreview() {
    ProfileNotLoginScreen()
}