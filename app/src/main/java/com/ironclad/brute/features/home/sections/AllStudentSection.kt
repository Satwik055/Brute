package com.ironclad.brute.features.home.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ironclad.brute.core.designsystem.components.BruteListItem
import com.ironclad.brute.core.designsystem.components.BruteListItemDivider
import com.ironclad.brute.core.designsystem.theme.onSurface
import com.ironclad.brute.core.main.ScreenDetail
import com.ironclad.brute.data.students.domain.model.StudentDto

@Composable
fun AllStudentSection(
    modifier: Modifier = Modifier,
    allStudents: List<StudentDto>,
    navController: NavController
) {
    LazyColumn(
        modifier = modifier
            .background(color = onSurface)
    ) {
        itemsIndexed(allStudents){index, student->
            BruteListItem(
                name = student.studentName?.uppercase() ?: "",
                roll = student.roll.toString(),
                course = student.course.toString(),
                onClick = { navController.navigate(ScreenDetail(student.studentId.toString()))}
            )
            if (index < allStudents.lastIndex)
                BruteListItemDivider()
        }
    }
}