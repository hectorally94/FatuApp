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
fun RecyclerBinStock(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier) {
        Text(text = "RecyclerBinStock")
    }
}

@Preview(name = "RecyclerBinStock")
@Composable
private fun PreviewRecyclerBinStock() {
    val context= LocalContext.current
    RecyclerBinStock(navController = NavController(context))
}