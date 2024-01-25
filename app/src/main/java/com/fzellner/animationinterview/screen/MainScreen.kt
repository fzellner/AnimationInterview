package com.fzellner.animationinterview.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skydoves.orbital.Orbital
import com.skydoves.orbital.animateSharedElementTransition
import com.skydoves.orbital.rememberContentWithOrbitalScope

@Composable
fun MainScreen() {
    var isTransformed by rememberSaveable {
        mutableStateOf(false)
    }

    val sharedTopBox = rememberContentWithOrbitalScope {
        TopBox(
            Modifier
                .padding(32.dp)
                .fillMaxWidth()
                .height(120.dp)
                .animateSharedElementTransition(
                    orbitalScope = this,
                    movementSpec = SpringSpec(stiffness = 200f)
                )
        )
    }


    val sharedCenterBox = rememberContentWithOrbitalScope {
        Box(
            modifier = if (isTransformed) {
                Modifier
                    .background(color = Color.Red)
                    .animateContentSize()
                    .fillMaxSize()
            } else {
                Modifier
                    .padding(32.dp)
                    .background(color = Color.Red, shape = RoundedCornerShape(12.dp))
                    .animateContentSize()
                    .fillMaxWidth()
                    .height(240.dp)

            }
        )
    }
    Orbital(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { isTransformed = !isTransformed }
    ) {
        if (isTransformed) {
            DetailScreen(
                sharedTopBox = { sharedTopBox() },
                sharedCenterBox = { sharedCenterBox() }
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
            ) {
                sharedTopBox()
                sharedCenterBox()
            }
        }
    }
}

@Composable
fun TopBox(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(color = Color.Gray, shape = RoundedCornerShape(16.dp))
    )

}

