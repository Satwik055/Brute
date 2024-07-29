package com.ironclad.brute.core.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ironclad.brute.core.designsystem.theme.Grey
import com.ironclad.brute.core.designsystem.theme.fontFamily

@Composable
fun BruteListItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    name:String,
    roll:String,
    course:String
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick.invoke() }
            .padding(vertical = 12.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,

    ){
        Column {
            Text(text = name, color = Color.White, fontFamily = fontFamily, fontWeight = FontWeight.Medium, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = roll, color = Color.White, fontFamily = fontFamily, fontSize = 10.sp)
        }
        Text(text = course, color = Color.White, fontFamily = fontFamily, fontSize = 10.sp)
    }
}




@Preview
@Composable
fun PreviewBruteListItem(modifier: Modifier = Modifier) {
    BruteListItem(name= "JOHN DOE", roll = "2023/3434", course = "Bcom(Hons)|E" , onClick = TODO())
}

fun Modifier.bottomBorder(strokeWidth: Dp, color: Color) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }

        Modifier.drawBehind {
            val width = size.width
            val height = size.height - strokeWidthPx/2

            drawLine(
                color = color,
                start = Offset(x = 0f, y = height),
                end = Offset(x = width , y = height),
                strokeWidth = strokeWidthPx
            )
        }
    }
)
