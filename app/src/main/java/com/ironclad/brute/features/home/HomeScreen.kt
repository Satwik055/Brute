package com.ironclad.brute.features.home

import android.widget.SearchView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ironclad.brute.core.ScreenSearch
import com.ironclad.brute.core.designsystem.components.BruteSearchbar
import com.ironclad.brute.core.designsystem.theme.Black
import com.ironclad.brute.core.designsystem.theme.fontFamily

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Black)
            .padding(16.dp)
    ){
        Column {
            Text(text = "Brute.", fontFamily = fontFamily, fontSize = 31.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(28.dp))
            BruteSearchbar(hint = "Search", onClick = { navController.navigate(ScreenSearch) } )
        }
    }
}
