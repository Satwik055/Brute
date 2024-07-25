package com.ironclad.brute.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ironclad.brute.core.designsystem.components.BruteListItem
import com.ironclad.brute.core.main.ScreenSearch
import com.ironclad.brute.core.designsystem.components.BruteSearchbar
import com.ironclad.brute.core.designsystem.theme.Black
import com.ironclad.brute.core.designsystem.theme.fontFamily
import com.ironclad.brute.core.designsystem.theme.onSurface
import com.ironclad.brute.core.main.ScreenDetail
import com.ironclad.brute.data.students.data.model.Student

val st1 = Student(studentName = "PHILLIP JEFFER", roll = "2023/0322", course = "Bcom(Hons)|E")
val st2 = Student(studentName = "ERRIE NICON", roll = "2023/0322", course = "Bcom(Hons)|E")
val st3 = Student(studentName = "JENIFFER DACOTA", roll = "2023/0322", course = "Bcom(Hons)|E")
val st4 = Student(studentName = "PHILLIP JEFFER", roll = "2023/0322", course = "Bcom(Hons)|E")
val st5 = Student(studentName = "NICHOLAS TWEEN", roll = "2023/0322", course = "Bcom(Hons)|E")
val st6 = Student(studentName = "JEFERY BIGGOT", roll = "2023/0322", course = "Bcom(Hons)|E")
val st7 = Student(studentName = "LIAN LO LANG", roll = "2023/0322", course = "Bcom(Hons)|E")

val stList1 = listOf(st1, st2, st3)
val stList2  = listOf(st1, st2, st3, st4, st5, st6, st7)

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Content(navController = navController)
    }
}

@Composable
private fun Content(modifier: Modifier = Modifier, navController: NavController) {
    Column {
        Text(text = "Brute.",modifier = modifier.clickable { navController.navigate(ScreenDetail)  },fontFamily = fontFamily, fontSize = 31.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(28.dp))
        BruteSearchbar(hint = "Search", onClick = { navController.navigate(ScreenSearch) } )

        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Recent", fontFamily = fontFamily, fontSize = 16.sp, color = Color.White)

        Spacer(modifier = Modifier.height(10.dp))

        //Recent Section
        LazyColumn(
            modifier = Modifier
                .background(color = onSurface)
                .padding(horizontal = 16.dp)
        ) {
            items(stList1){
                BruteListItem(name = it.studentName, roll = it.roll, course = it.course)
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "All", fontFamily = fontFamily, fontSize = 16.sp, color = Color.White)

        Spacer(modifier = Modifier.height(10.dp))

        //All Section
        LazyColumn(
            modifier = Modifier
                .background(color = onSurface)
                .padding(horizontal = 16.dp)
        ) {
            items(stList2){
                BruteListItem(name = it.studentName, roll = it.roll, course = it.course)
            }
        }
    }

}
