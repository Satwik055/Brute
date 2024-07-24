package com.ironclad.brute.core.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ironclad.brute.core.designsystem.theme.Black
import com.ironclad.brute.core.designsystem.theme.Hint
import com.ironclad.brute.core.designsystem.theme.fontFamily

@Composable
fun BruteSearchView(
    modifier: Modifier = Modifier,
    value:String,
    autoFocus:Boolean = false,
    onValueChange: (String) -> Unit,
    hint:String
    ) {

    val focusRequester = remember{ FocusRequester() }
    if(autoFocus){
        LaunchedEffect(Unit){
            focusRequester.requestFocus()
        }
    }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .focusRequester(focusRequester),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = hint, fontFamily = fontFamily, color = Hint) },
        singleLine = true,
        colors = TextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White,focusedContainerColor = Color.Transparent, cursorColor = Color.White, unfocusedContainerColor = Color.Transparent, unfocusedIndicatorColor = Color.White, focusedIndicatorColor = Color.White),
        textStyle = TextStyle(fontFamily = fontFamily, fontSize = 16.sp)
    )
}

@Preview
@Composable
fun PreviewSearchView(modifier: Modifier = Modifier) {
    var searchText by remember { mutableStateOf("") }
    BruteSearchView(value = searchText , onValueChange = {searchText = it}, hint = "Tejas is a gudda")
}