package com.greatwolf.tidoy.presentation.screen.register

import android.widget.Space
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import com.greatwolf.tidoy.presentation.component.CustomButtonStyle
import com.greatwolf.tidoy.presentation.component.CustomTextInput
import com.greatwolf.tidoy.presentation.component.CustomTextInputStyle
import com.greatwolf.tidoy.ui.theme.Neutral100
import com.greatwolf.tidoy.ui.theme.PrimaryMain
import com.greatwolf.tidoy.ui.theme.manropeFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen() {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    ModalBottomSheet(
        modifier = Modifier
            .padding(top = 64.dp)
            .fillMaxSize(),
        sheetState = sheetState,
        onDismissRequest = { },
        containerColor = Color.White,
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.size(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.title_welcome),
                    fontSize = 18.sp,
                    color = Neutral100,
                    fontWeight = FontWeight.Bold,
                    fontFamily = manropeFontFamily
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.close),
                    contentDescription = null
                )
            }
            var usernameError by remember { mutableStateOf<Int>(-1) }
            var isUsernameError by remember { mutableStateOf<Boolean>(false) }
            Spacer(modifier = Modifier.size(24.dp))
            CustomTextInput(
                title = R.string.title_username,
                placeholder = R.string.placeholder_example_username,
                error = usernameError,
                isError = isUsernameError
            )
            var emailError by remember { mutableStateOf<Int>(-1) }
            var isEmailError by remember { mutableStateOf<Boolean>(false) }
            CustomTextInput(
                title = R.string.title_email,
                placeholder = R.string.placeholder_example_email,
                error = emailError,
                isError = isEmailError
            )

            var phoneError by remember { mutableStateOf<Int>(-1) }
            var isPhoneError by remember { mutableStateOf<Boolean>(false) }
            CustomTextInput(
                title = R.string.title_phone,
                placeholder = R.string.placeholder_example_phone,
                error = phoneError,
                isError = isPhoneError,
                style = CustomTextInputStyle.PHONE
            )

            var passwordError by remember { mutableStateOf<Int>(-1) }
            var isPasswordError by remember { mutableStateOf<Boolean>(false) }
            CustomTextInput(
                title = R.string.title_password,
                placeholder = R.string.placeholder_example_password,
                error = passwordError,
                isError = isPasswordError,
                style = CustomTextInputStyle.PASSWORD
            )

            var confirmPasswordError by remember { mutableStateOf<Int>(-1) }
            var isConfirmPasswordError by remember { mutableStateOf<Boolean>(false) }
            CustomTextInput(
                title = R.string.title_confirm_password,
                placeholder = R.string.placeholder_example_password,
                error = confirmPasswordError,
                isError = isConfirmPasswordError,
                style = CustomTextInputStyle.PASSWORD
            )

            Spacer(modifier = Modifier.size(32.dp))

            CustomButton(
                text = R.string.btn_register
            ) { }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.text_have_account),
                    fontSize = 12.sp,
                    color = Neutral100,
                    fontFamily = manropeFontFamily
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = stringResource(id = R.string.btn_login_here),
                    fontSize = 12.sp,
                    color = PrimaryMain,
                    fontWeight = FontWeight.Bold,
                    fontFamily = manropeFontFamily
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}