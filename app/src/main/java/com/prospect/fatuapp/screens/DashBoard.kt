package com.prospect.fatuapp.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DashBoard() {
    Box() {
        Text(text = "DashBoard")
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(name = "DashBoard")
@Composable
private fun PreviewDashBoard() {
    DashBoard()
}