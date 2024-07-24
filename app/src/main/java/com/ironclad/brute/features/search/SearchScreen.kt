package com.ironclad.brute.features.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ironclad.brute.core.designsystem.components.BruteSearchView
import com.ironclad.brute.core.designsystem.theme.Black

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var searchText by remember { mutableStateOf("") }

    Box (
        modifier = modifier.fillMaxSize().background(Black)
    ){
        Column {
            BruteSearchView(
                value = searchText,
                onValueChange = {searchText = it},
                hint = "Search students",
                autoFocus = true
            )
        }
    }

    
}