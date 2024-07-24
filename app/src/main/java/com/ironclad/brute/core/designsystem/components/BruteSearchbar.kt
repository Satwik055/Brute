package com.ironclad.brute.core.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ironclad.brute.core.designsystem.theme.Black
import com.ironclad.brute.core.designsystem.theme.Hint
import com.ironclad.brute.core.designsystem.theme.fontFamily
import com.ironclad.brute.core.designsystem.theme.onSurface
import com.ironclad.brute.core.designsystem.theme.robotoMono

@Composable
fun BruteSearchbar(
    modifier: Modifier = Modifier,
    hint:String,
    onClick: () -> Unit,
    ) {
    var foo = ""

    TextField(
        modifier = modifier.fillMaxWidth().clickable { onClick() },
        shape = RoundedCornerShape(1.dp),
        value = foo,
        onValueChange = {foo = it },
        enabled = false,
        placeholder = { Text(text = hint, fontFamily = fontFamily, color = Hint) },
        colors = TextFieldDefaults.colors( disabledContainerColor = onSurface, unfocusedIndicatorColor = Color.Transparent, focusedIndicatorColor = Color.Transparent),
    )
}

@Preview
@Composable
fun SearchbarPreview(modifier: Modifier = Modifier) {
    BruteSearchbar(hint = "Search", onClick = { TODO() })
}