package com.ironclad.brute.features.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ironclad.brute.core.designsystem.components.BruteSearchbar
import com.ironclad.brute.core.designsystem.theme.fontFamily
import com.ironclad.brute.core.main.ScreenDetail
import com.ironclad.brute.core.main.ScreenSearch
import com.ironclad.brute.data.students.domain.model.Student
import com.ironclad.brute.features.home.sections.AllStudentSection
import com.ironclad.brute.features.home.sections.RecentSection


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {

    val homeViewModel: HomeViewModel = viewModel()
    val state = homeViewModel.allStudentState.value

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        val allStudent = state.student
        val recentSearches = allStudent.take(3)
        Content(
            navController = navController,
            allStudents = allStudent,
            recentSearches = recentSearches
        )
    }
}


@Composable
private fun Content(modifier: Modifier = Modifier, navController: NavController, allStudents:List<Student>, recentSearches:List<Student>) {
    Column {
        Text(text = "Brute.",modifier = modifier.clickable { navController.navigate(ScreenDetail)  },fontFamily = fontFamily, fontSize = 31.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(28.dp))

        BruteSearchbar(hint = "Search", onClick = { navController.navigate(ScreenSearch) } )
        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "Recent", fontFamily = fontFamily, fontSize = 16.sp, color = Color.White)
        Spacer(modifier = Modifier.height(10.dp))

        RecentSection(recentSearches = recentSearches, navController = navController)
        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "All", fontFamily = fontFamily, fontSize = 16.sp, color = Color.White)
        Spacer(modifier = Modifier.height(10.dp))

        AllStudentSection(allStudents = allStudents, navController = navController)

    }

}
