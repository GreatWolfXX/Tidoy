package com.greatwolf.tidoy.presentation.screen.editprofile

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.greatwolf.tidoy.presentation.screen.profile.ProfileMenuItemStyle
import com.greatwolf.tidoy.ui.theme.Neutral100
import com.greatwolf.tidoy.ui.theme.Neutral80
import com.greatwolf.tidoy.ui.theme.SwitchBackgroundOff
import com.greatwolf.tidoy.ui.theme.SwitchBackgroundOn
import com.greatwolf.tidoy.ui.theme.Text80Dark
import com.greatwolf.tidoy.ui.theme.manropeFontFamily

@Composable
fun EditProfileScreen() {
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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        Icon(
            modifier = Modifier.scale(scaleX = -1.2f, scaleY = 1.2f),
            imageVector = ImageVector.vectorResource(id = R.drawable.arrow_icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = stringResource(id = R.string.title_edit_profile),
            color = if(isSystemInDarkTheme()) Color.White else Neutral100,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = manropeFontFamily,
            textAlign = TextAlign.Start
        )
    }
    Spacer(modifier = Modifier.size(16.dp))
    Image(
        modifier = Modifier.size(100.dp),
        painter = painterResource(id = R.drawable.profile_img),
        contentDescription = null
    )
    CustomButton(
        modifier = Modifier.wrapContentWidth(),
        text = R.string.title_edit_photo,
        textPaddingValues = PaddingValues(vertical = 11.dp, horizontal = 12.dp),
        textFontSize = 12.sp,
        cornerRadius = 8.dp,
        style = CustomButtonStyle.SECONDARY
    ) {

    }
    Spacer(modifier = Modifier.size(16.dp))
}

@Composable
fun GeneralInfo() {
    EditProfileInfoItem(
        title = R.string.title_name,
        "John Doe" //Testing field
    )
    EditProfileInfoItem(
        title = R.string.title_email,
        "Johndoe@gmail.com" //Testing field
    )
    EditProfileInfoItem(
        title = R.string.title_password,
        "••••••••" //Testing field
    )
    EditProfileInfoItem(
        title = R.string.title_gender,
        "Male" //Testing field
    )
    EditProfileInfoItem(
        title = R.string.title_number,
        "+62 8965765432" //Testing field
    )
    EditProfileMenuItem(
        text = R.string.title_forgot_password
    )
}

@Composable
fun EditProfileInfoItem(
    @StringRes
    title: Int,
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                modifier = Modifier.padding(vertical = 2.dp),
                text = stringResource(id = title),
                color = if(isSystemInDarkTheme()) Text80Dark else Neutral80,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = manropeFontFamily,
                textAlign = TextAlign.Start
            )
            Text(
                modifier = Modifier.padding(vertical = 2.dp),
                text = text,
                color = if(isSystemInDarkTheme()) Color.White else Neutral100,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = manropeFontFamily,
                textAlign = TextAlign.Start
            )
        }
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.change_icon),
            contentDescription = null,
            tint = if(isSystemInDarkTheme()) Text80Dark else Neutral80
        )
    }
}

@Composable
fun EditProfileMenuItem(
    @StringRes
    text: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
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
fun EditProfileScreenPreview() {
    EditProfileScreen()
}