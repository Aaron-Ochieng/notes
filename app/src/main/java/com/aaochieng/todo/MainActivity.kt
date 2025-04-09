package com.aaochieng.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.aaochieng.todo.onboading.OnBoardingUI
import com.aaochieng.todo.ui.theme.ToDoTheme
import com.aaochieng.todo.screens.HomeScreen
import com.aaochieng.todo.onboading.OnBoardingPrefs
import com.aaochieng.todo.screens.LoadingScreen
import com.aaochieng.todo.screens.UIState

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        setContent {
            var uiState by remember { mutableStateOf<UIState>(UIState.Loading) }
            val context = LocalContext.current

            LaunchedEffect(key1 = true) {
                val isOnBoardingComplete = OnBoardingPrefs.isOnBoardingCompleted(context)
                uiState = if (isOnBoardingComplete) {
                    UIState.HomeScreen
                } else {
                    UIState.OnBoardingUI
                }
            }
            ToDoTheme {
                when (uiState) {
                    UIState.Loading -> LoadingScreen()
                    UIState.OnBoardingUI -> OnBoardingUI(onFinished = {
                        OnBoardingPrefs.setOnBoardingCompleted(context)
                        uiState = UIState.HomeScreen
                    })
                    UIState.HomeScreen -> HomeScreen()
                }

            }
        }
    }
}


