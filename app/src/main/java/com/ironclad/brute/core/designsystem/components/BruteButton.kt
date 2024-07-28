package com.ironclad.brute.core.designsystem.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ironclad.brute.R
import com.ironclad.brute.core.designsystem.theme.Black
import com.ironclad.brute.core.designsystem.theme.White
import com.ironclad.brute.core.designsystem.theme.fontFamily

@Composable
fun BruteButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text:String,
    color: Color = White
){

    Button(
        modifier = modifier
            .height(55.dp)
            .fillMaxWidth(),
        onClick = {onClick.invoke()},
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(containerColor = color),
    ) {
        Text(text = text, fontSize = 16.sp, fontFamily = fontFamily, color = Black)
        Spacer(modifier = Modifier.width(5.dp))
        Icon(painter = painterResource(id = R.drawable.ic_hyperlink), tint = Black, modifier = Modifier.size(17.dp), contentDescription = null)
    }

}