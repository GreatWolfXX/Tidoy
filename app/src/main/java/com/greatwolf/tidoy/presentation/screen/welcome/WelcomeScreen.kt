package com.greatwolf.tidoy.presentation.screen.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.greatwolf.tidoy.R
import com.greatwolf.tidoy.navigation.Screen
import com.greatwolf.tidoy.presentation.component.CustomButton
import com.greatwolf.tidoy.presentation.component.CustomButtonStyle
import com.greatwolf.tidoy.ui.theme.BackgroundMain
import com.greatwolf.tidoy.ui.theme.Neutral100
import com.greatwolf.tidoy.ui.theme.Neutral30
import com.greatwolf.tidoy.ui.theme.Neutral60
import com.greatwolf.tidoy.ui.theme.Neutral80
import com.greatwolf.tidoy.ui.theme.manropeFontFamily
import com.greatwolf.tidoy.util.OnBoardingPage
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@Composable
fun WelcomeScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: WelcomeViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState(
        pageCount = { pages.size }
    )

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val visibility = pagerState.currentPage != pages.size.dec()
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) {position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        LineIndicator(
            modifier = Modifier.weight(1f),
            state = pagerState
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .weight(2f)
        ) {
            val density = LocalDensity.current
            AnimatedVisibility(
                modifier = Modifier.weight(1f, false),
                visible = visibility,
                enter = slideInHorizontally {
                    with(density) { -40.dp.roundToPx() }
                } + expandHorizontally(
                    expandFrom = Alignment.Start
                ) + fadeIn(
                    initialAlpha = 0.3f
                ),
                exit = slideOutHorizontally() + shrinkHorizontally() + fadeOut()
            ) {
                CustomButton(
                    text = R.string.btn_skip,
                    style = CustomButtonStyle.SECONDARY
                ) {
                    navigateToHome(
                        viewModel = viewModel,
                        navController = navController
                    )
                }
            }

            val coroutineScope = rememberCoroutineScope()
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = if (visibility) 12.dp else 0.dp)
                    .weight(4f, false)
                    .animateContentSize(
                        animationSpec = tween(200),
                        alignment = Alignment.Center
                    ),
                text = if(visibility) R.string.btn_next else R.string.btn_get_started,
                iconEnd = if(visibility) R.drawable.arrow_forward else -1
            ) {
                if(visibility && pagerState.canScrollForward) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage.inc())
                    }
                } else {
                    navigateToHome(
                        viewModel = viewModel,
                        navController = navController
                    )
                }
            }
        }
    }
}

fun navigateToHome(
    viewModel: WelcomeViewModel,
    navController: NavController
) {
    viewModel.saveOnBoarding(completed = true)
    navController.popBackStack()
    navController.navigate(Screen.Home)
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(28.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 32.dp),
            text = stringResource(id = onBoardingPage.title),
            color = if(isSystemInDarkTheme()) Color.White else Neutral100,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = manropeFontFamily,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 32.dp),
            text = stringResource(id = onBoardingPage.description),
            color = Neutral60,
            fontSize = 16.sp,
            fontFamily = manropeFontFamily,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun LineIndicator(
    modifier: Modifier = Modifier,
    state: PagerState
) {
    val baseWidth = 8.dp
    val maxWidth = 26.dp
    val space = 4.dp

    Row(
        modifier = modifier
            .width((maxWidth + space) * state.pageCount),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(state.pageCount) { index ->
            val width: Dp by animateDpAsState(
                targetValue = when(index) {
                    state.currentPage -> maxWidth - (maxWidth - baseWidth) * state.currentPageOffsetFraction.absoluteValue
                    state.targetPage -> baseWidth + (maxWidth - baseWidth) * state.currentPageOffsetFraction.absoluteValue
                    else -> baseWidth
                }, label = ""
            )
            val indicatorBaseColor = if(isSystemInDarkTheme()) Neutral80 else Neutral30
            Box(
                modifier = Modifier
                    .padding(horizontal = space / 2)
                    .width(width)
                    .height(8.dp)
                    .background(
                        color = if (index == state.currentPage) BackgroundMain else indicatorBaseColor,
                        shape = CircleShape
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstOnBoardingPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.First)
    }
}

@Preview(showBackground = true)
@Composable
fun SecondOnBoardingPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Second)
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdOnBoardingPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Third)
    }
}