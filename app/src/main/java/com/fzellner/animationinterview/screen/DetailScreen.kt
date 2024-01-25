package com.fzellner.animationinterview.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(
    sharedTopBox: @Composable () -> Unit,
    sharedCenterBox: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        sharedCenterBox()
        Column {
            sharedTopBox()
            AnimatedVisibility(
                remember { MutableTransitionState(false) }.apply { targetState = true },
                enter = slideInVertically(
                    initialOffsetY = { it / 2 }
                ),
                exit = slideOutVertically(
                    targetOffsetY = { it / 2 }
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(top = 32.dp, start = 32.dp, end = 32.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        )
                ) {
                    Text("Detail Screen")
                }
            }
        }
    }
}
