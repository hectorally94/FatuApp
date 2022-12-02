package com.prospect.fatuapp.screens

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun Splash(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier) {
        Text(text = "Splash Screen")
    }
}

@Preview(name = "Splash")
@Composable
private fun PreviewSplash() {
    val context= LocalContext.current
    Splash(navController=NavController(context))
}