package com.ironclad.brute.features.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ironclad.brute.core.designsystem.components.BruteListItem
import com.ironclad.brute.core.designsystem.theme.onSurface
import com.ironclad.brute.core.main.ScreenDetail
import com.ironclad.brute.data.students.domain.model.Student

@Composable
fun SearchResultsSection(
    modifier: Modifier = Modifier,
    searchResult: List<Student>,
    navController: NavController
) {
    LazyColumn(
        modifier = modifier
            .background(color = onSurface)
            .padding(horizontal = 16.dp)
    ) {
        items(searchResult){
            BruteListItem(
                name = it.studentName,
                roll = it.roll,
                course = it.course,
                onClick = { navController.navigate(ScreenDetail(it.studentId))}
            )
        }
    }
}