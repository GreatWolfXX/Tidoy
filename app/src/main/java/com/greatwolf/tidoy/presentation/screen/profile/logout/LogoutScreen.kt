package com.greatwolf.tidoy.presentation.screen.profile.logout

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.greatwolf.tidoy.R
import com.greatwolf.tidoy.presentation.component.CustomButton
import com.greatwolf.tidoy.ui.theme.Neutral100
import com.greatwolf.tidoy.ui.theme.Neutral80
import com.greatwolf.tidoy.ui.theme.TextDanger
import com.greatwolf.tidoy.ui.theme.manropeFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogoutScreen() {
    val sheetState = rememberModalBottomSheetState()
    val containerColor = if(isSystemInDarkTheme()) Neutral100 else Color.White
    ModalBottomSheet(
        modifier = Modifier
            .padding(top = 48.dp)
            .fillMaxWidth(),
        sheetState = sheetState,
        onDismissRequest = { },
        containerColor = containerColor,
        contentColor = if(isSystemInDarkTheme()) Color.White else Neutral100
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.title_logout),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = manropeFontFamily
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.close),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = stringResource(id = R.string.desc_logout),
                color = Neutral80,
                fontSize = 14.sp,
                fontFamily = manropeFontFamily
            )
            Spacer(modifier = Modifier.size(24.dp))
            CustomButton(
                text = R.string.title_logout,
                customBackgroundColor = TextDanger
            ) {

            }
            Spacer(modifier = Modifier.size(96.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LogoutScreenPreview() {
    LogoutScreen()
}