package com.greatwolf.tidoy.presentation.component

import android.media.Image
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.greatwolf.tidoy.R
import com.greatwolf.tidoy.ui.theme.Neutral100
import com.greatwolf.tidoy.ui.theme.Neutral40
import com.greatwolf.tidoy.ui.theme.Neutral70
import com.greatwolf.tidoy.ui.theme.Neutral80
import com.greatwolf.tidoy.ui.theme.Neutral90
import com.greatwolf.tidoy.ui.theme.Text80Dark
import com.greatwolf.tidoy.ui.theme.manropeFontFamily

@Composable
fun NotificationPromoComponent(
    title: String,
    date: String,
    image: String,
    description: String,
    code: String,
    limit: Int
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.promo_icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                modifier = Modifier.weight(1f),
                text = title,
                color = if(isSystemInDarkTheme()) Color.White else Neutral100,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = manropeFontFamily,
                textAlign = TextAlign.Start
            )
            Text(
                text = date,
                color = if(isSystemInDarkTheme()) Color.White else Neutral100,
                fontSize = 10.sp,
                fontFamily = manropeFontFamily,
                textAlign = TextAlign.Start
            )
        }
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .padding(vertical = 8.dp),
            model = R.drawable.test_promo_image, //Test image
            contentDescription = null
        )
        Text(
            text = description,
            color = if(isSystemInDarkTheme()) Text80Dark else Neutral80,
            fontSize = 12.sp,
            fontFamily = manropeFontFamily,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = if (isSystemInDarkTheme()) Neutral90 else Color.White,
                    shape = RoundedCornerShape(12.dp)
                )
                .border(
                    BorderStroke(
                        width = 1.dp,
                        color = if (isSystemInDarkTheme()) Neutral70 else Neutral40
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = code,
                color = if(isSystemInDarkTheme()) Color.White else Neutral100,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = manropeFontFamily,
                textAlign = TextAlign.Start
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.copy_icon),
                contentDescription = null,
                tint = if(isSystemInDarkTheme()) Color.White else Neutral100
            )
        }
        Spacer(modifier = Modifier.size(6.dp))
        Text(
            text = stringResource(id = R.string.title_user_promo, limit),
            color = if(isSystemInDarkTheme()) Text80Dark else Neutral80,
            fontSize = 12.sp,
            fontFamily = manropeFontFamily,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .height(1.dp)
            .background(Neutral40)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationPromoComponentPreview() {
    NotificationPromoComponent(
        title = "Get Disc 50%",
        date = "4/4/24",
        image = "",
        description = "Hi, we have good news for you! Get 50% off all products in our store. This promo is valid for a limited time, so don't miss out.",
        code = "ABCD50",
        limit = 50
    )
}