package com.ironclad.brute.features.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ironclad.brute.core.designsystem.components.BruteListItem
import com.ironclad.brute.core.designsystem.components.BruteSearchView
import com.ironclad.brute.core.designsystem.theme.Black
import com.ironclad.brute.core.designsystem.theme.onSurface
import com.ironclad.brute.core.main.ScreenDetail
import com.ironclad.brute.data.students.domain.model.Student
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking

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
    var searchText by remember { mutableStateOf("") }
    val state = viewModel.searchResultState.value


    Column {
        BruteSearchView(
            value = searchText,
            onValueChange = {
                searchText = it
                viewModel.onSearchTextChange(searchText)
            },
            hint = "Search students",
            autoFocus = true
        )

        when {
            state.isLoading -> CircularProgressIndicator()
            state.error.isNotEmpty() -> Text(text = state.error, color = Color.Red)
            state.student.isNotEmpty() -> SearchResultsSection(searchResult = state.student, navController = navController)
        }
    }
}

