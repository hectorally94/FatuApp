package com.prospect.fatuapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun OderReportDetails(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier) {
        Text(text = "OderReportDetails")
    }
}

@Preview(name = "OderReportDetails")
@Composable
private fun PreviewOderReportDetails() {
    val context= LocalContext.current
    OderReportDetails(navController = NavController(context))
}