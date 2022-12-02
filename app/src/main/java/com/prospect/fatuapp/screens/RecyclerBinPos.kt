package com.prospect.fatuapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun RecyclerBinPos(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier) {
        Text(text = "RecyclerBinPos")
    }
}

@Preview(name = "RecyclerBinPos")
@Composable
private fun PreviewRecyclerBinPos() {
    val context= LocalContext.current

    RecyclerBinPos(navController = NavController(context))
}