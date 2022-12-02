package com.prospect.fatuapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun OderedProduct(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier) {
        Text(text = "OderedProduct")
    }
}

@Preview(name = "OderedProduct")
@Composable
private fun PreviewOderedProduct() {
    val context= LocalContext.current
    OderedProduct(navController = NavController(context))
}