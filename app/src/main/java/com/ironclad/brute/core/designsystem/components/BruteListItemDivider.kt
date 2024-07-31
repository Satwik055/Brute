package com.ironclad.brute.core.designsystem.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ironclad.brute.core.designsystem.theme.Grey

@Composable
fun BruteListItemDivider(
    modifier: Modifier = Modifier,
    thickness:Dp = Dp.Hairline,
    color: Color = Grey
) {
    Divider(
        modifier = modifier.padding(horizontal = 16.dp),
        thickness = thickness, color = color,
        )
}