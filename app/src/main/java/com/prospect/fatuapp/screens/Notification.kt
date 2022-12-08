package com.prospect.fatuapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Notification(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "Notification")
    }
}

@Preview(name = "Notification")
@Composable
private fun PreviewNotification() {
    Notification()
}