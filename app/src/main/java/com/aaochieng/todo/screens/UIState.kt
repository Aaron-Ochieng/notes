package com.aaochieng.todo.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

sealed class UIState {
    data object Loading: UIState()
    data object OnBoardingUI: UIState()
    data object HomeScreen: UIState()
}


@Composable
fun LoadingScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        CircularProgressIndicator()
    }
}