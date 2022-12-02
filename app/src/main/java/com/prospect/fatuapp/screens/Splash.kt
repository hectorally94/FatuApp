package com.prospect.fatuapp.screens

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prospect.fatuapp.navigations.Screens

@Composable
fun Splash(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier) {
        Column() {

            Text(text = "Splash Screen")
            Button(onClick = {
                navController.navigate(Screens.Oder.name)
            }) {
                Text(text = "Go Oder")
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