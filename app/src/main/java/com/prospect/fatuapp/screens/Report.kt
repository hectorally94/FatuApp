package com.prospect.fatuapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun Report(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier) {
        Text(text = "Report")
    }
}

@Preview(name = "Report")
@Composable
private fun PreviewReport() {
    Report(navController = NavController(LocalContext.current))
}