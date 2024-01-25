package com.fzellner.animationinterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fzellner.animationinterview.screen.MainScreen
import com.fzellner.animationinterview.ui.theme.AnimationInterviewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationInterviewTheme {
              MainScreen()
            }
        }
    }
}