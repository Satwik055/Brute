package com.ironclad.brute.features.home.sections

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
fun AllStudentSection(
    modifier: Modifier = Modifier,
    allStudents: List<Student>,
    navController: NavController
) {
    LazyColumn(
        modifier = modifier
            .background(color = onSurface)
    ) {
        itemsIndexed(allStudents){index, student->
            BruteListItem(
                name = student.studentName,
                roll = student.roll,
                course = student.course,
                onClick = { navController.navigate(ScreenDetail(student.studentId))}
            )
            if (index < allStudents.lastIndex)
                BruteListItemDivider()
        }
    }
}