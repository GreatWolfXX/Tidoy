package com.greatwolf.tidoy.presentation.screen.splash

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greatwolf.tidoy.data.local.repository.DataStoreRepository
import com.greatwolf.tidoy.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    private val _startDestination: MutableState<Screen> = mutableStateOf(Screen.Welcome)
    val startDestination: State<Screen> = _startDestination

    init {
        viewModelScope.launch {
            repository.readingOnBoardingState().collect { completed ->
                if(completed) {
                    _startDestination.value = Screen.Home
                } else {
                    _startDestination.value = Screen.Welcome
                }
            }
        }
    }
}