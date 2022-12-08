package com.prospect.fatuapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun RestProduct(
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        Text(text = "RestProduct")
    }
}

@Preview(name = "RestProduct")
@Composable
private fun PreviewRestProduct() {
    RestProduct()
}