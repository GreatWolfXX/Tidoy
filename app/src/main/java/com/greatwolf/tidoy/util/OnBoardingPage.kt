package com.greatwolf.tidoy.util

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.greatwolf.tidoy.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    @StringRes
    val title: Int,
    @StringRes
    val description: Int
) {
    data object First : OnBoardingPage(
        image = R.drawable.image_first_onboarding,
        title = R.string.title_first_onboarding,
        description = R.string.description_first_onboarding
    )

    data object Second : OnBoardingPage(
        image = R.drawable.image_second_onboarding,
        title = R.string.title_second_onboarding,
        description = R.string.description_second_onboarding
    )

    data object Third : OnBoardingPage(
        image = R.drawable.image_third_onboarding,
        title = R.string.title_third_onboarding,
        description = R.string.description_third_onboarding
    )
}