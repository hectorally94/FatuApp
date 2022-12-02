package com.prospect.fatuapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun AddProductToPos(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier) {
        Text(text = "AddProductToPos")
    }
}

@Preview(name = "AddProductToPos")
@Composable
private fun PreviewAddProductToPos() {
    val context= LocalContext.current
    AddProductToPos(navController = NavController(context))
}