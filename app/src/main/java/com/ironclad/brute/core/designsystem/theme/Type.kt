package com.ironclad.brute.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ironclad.brute.R


val robotoMono = FontFamily(
    Font(R.font.robotomono_thin, FontWeight.Thin),
    Font(R.font.robotomono_regular, FontWeight.Normal),
    Font(R.font.robotomono_medium, FontWeight.Medium),
    Font(R.font.robotomono_bold, FontWeight.Bold)
)

val fontFamily = robotoMono

// Set of Material typography styles to start with
val Typography = Typography(
    bodySmall = TextStyle(color = White, fontFamily = fontFamily, fontSize = 14.sp),
    headlineLarge = TextStyle( color = White, fontFamily = fontFamily, fontSize = 31.sp, fontWeight = FontWeight.SemiBold),
)