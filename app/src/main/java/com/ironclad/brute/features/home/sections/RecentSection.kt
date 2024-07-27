package com.ironclad.brute.features.home.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.unit.dp
import com.ironclad.brute.core.designsystem.components.BruteListItem
import com.ironclad.brute.core.designsystem.theme.onSurface
import com.ironclad.brute.data.students.domain.model.Student

@Composable
fun RecentSection(modifier: Modifier = Modifier, recentSearches:List<Student>) {
    LazyColumn(
        modifier = modifier
            .background(color = onSurface)
            .padding(horizontal = 16.dp)
    ) {
        items(recentSearches){
            BruteListItem(name = it.studentName, roll = it.roll, course = it.course)
        }
    }

}