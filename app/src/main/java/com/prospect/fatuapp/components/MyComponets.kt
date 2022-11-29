package com.prospect.fatuapp.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp


@ExperimentalComposeUiApi
@Composable
fun MyInputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {},
    keyboardOptions: KeyboardOptions,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(
            textColor=Color.Black,
            backgroundColor = Color.Transparent,
            cursorColor = Color(0xffAC7088),
            focusedIndicatorColor = Color(0xffAC7088),
            focusedLabelColor = Color(0xFFDEB6AB)),
        maxLines = maxLine,
        label = { Text(text = label) },
        keyboardOptions=keyboardOptions,
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        }),        modifier = modifier
    )

}

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Button(onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xffAC7088),
            contentColor = Color.White
        )) {

        Text(text =text,
            fontWeight = FontWeight.Bold,
        fontSize =15.sp
        )

    }

}

