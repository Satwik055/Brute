package com.ironclad.brute.features.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ironclad.brute.core.designsystem.components.BruteSearchView
import com.ironclad.brute.core.designsystem.theme.Black

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box (
        modifier = modifier
            .fillMaxSize()
            .background(Black)
    ){
        Content(navController = navController)
    }
}

@Composable
private fun Content(navController: NavController) {

    val viewModel:SearchScreenViewModel = viewModel()
    val state = viewModel.searchResultState.value
    var searchText = viewModel.searchText.collectAsState().value


    Column(modifier = Modifier.fillMaxSize()) {
        BruteSearchView(
            value = searchText,
            onValueChange = {
                searchText = it
                viewModel.onSearchTextChange(searchText)
            },
            hint = "Search students",
            autoFocus = true
        )
        Box(modifier = Modifier.fillMaxSize()){
            when {
                state.isLoading -> CircularProgressIndicator()
                state.error.isNotEmpty() -> Text(text = state.error, color = Color.Red, modifier = Modifier.align(Alignment.Center))
                state.student.isNotEmpty() -> SearchResultsSection(searchResult = state.student, navController = navController)
            }
        }
    }
}

