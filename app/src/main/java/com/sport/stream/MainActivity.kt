package com.sport.stream

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sport.stream.ui.theme.TestAppTheme
import com.sport.stream.screen.MainScreen
import com.sport.stream.screen.auth.AuthScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestAppTheme {
                AuthScreen()
            }
        }
    }
}

