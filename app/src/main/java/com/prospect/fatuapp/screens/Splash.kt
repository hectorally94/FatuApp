package com.prospect.fatuapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Splash(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier) {
        Column {

            Text(text = "Splash Screen")
            Button(onClick = {
               // navController.navigate(AcButtomNavigationActivity)
            }) {
                Text(text = "go home")
            }
        }
    }
}

@Preview(name = "Splash")
@Composable
private fun PreviewSplash() {
    val context= LocalContext.current
    Splash(navController=NavController(context))
}