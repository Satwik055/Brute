package com.ironclad.brute.features.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ironclad.brute.core.designsystem.components.BruteListItem
import com.ironclad.brute.core.designsystem.components.BruteListItemDivider
import com.ironclad.brute.core.designsystem.theme.Grey
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
    ) {
        itemsIndexed(searchResult){index, student->
            BruteListItem(
                name = student.studentName.uppercase(),
                roll = student.roll,
                course = student.course,
                onClick = { navController.navigate(ScreenDetail(student.studentId))}
            )
            if (index < searchResult.lastIndex)
                BruteListItemDivider()
        }
    }
}