package com.ironclad.brute.features.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ironclad.brute.core.designsystem.components.BruteButton
import com.ironclad.brute.core.designsystem.theme.BruteTheme
import com.ironclad.brute.core.main.ScreenPortal
import com.ironclad.brute.data.students.domain.model.StudentDto
import java.util.Locale

@Composable
fun DetailScreen(modifier: Modifier = Modifier, navController: NavController, studentId:String) {
    
    val viewModel:DetailScreenViewModel = viewModel()
    val state = viewModel.detailScreenState.value

    //TODO: This is sussy af
    LaunchedEffect(Unit) {
        viewModel.getStudentById(studentId)
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        BruteTheme {
            when{
                state.isLoading->
                    CircularProgressIndicator()

                state.error.isNotBlank() -> {
                    Text(text = state.error, color = Color.Red)
                }

                else -> {
                    val student = state.student
                    Content(navController = navController, student = student)
                }
            }
        }
    }

}

@Composable
private fun Content(navController: NavController, student: StudentDto?) {

    val name = student?.studentName?.uppercase()
    val roll= student?.roll
    val email = student?.email
    val phone = student?.phone
    val course = student?.course
    val address = student?.address
    val gender = student?.gender
    val fatherName = student?.fatherName?.capitalize(Locale.getDefault())
    val mothersName = student?.motherName?.capitalize(Locale.getDefault())
    val admissionDate = student?.admissionDate
    val dob = student?.dob
    val sakshamPassword = student?.password
    val studentType = student?.studentType
    val enrollmentNo = student?.enrollmentNo
    val category = student?.category



    Column{
        Text(text = name.toString(), style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(15.dp))
        Divider(thickness = Dp.Hairline, color = Color.White)
        Spacer(modifier = Modifier.height(25.dp))

        Column (
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ){
            Text(text = "Roll: $roll", style = MaterialTheme.typography.bodySmall)
            Text(text = "Email: $email", style = MaterialTheme.typography.bodySmall)
            Text(text = "Phone: $phone", style = MaterialTheme.typography.bodySmall)
            Text(text = "Course: $course", style = MaterialTheme.typography.bodySmall)
            Text(text = "Address: $address", style = MaterialTheme.typography.bodySmall)
            Text(text = "Gender: $gender", style = MaterialTheme.typography.bodySmall)
        }
        Column (
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ){
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Father's name: $fatherName", style = MaterialTheme.typography.bodySmall)
            Text(text = "Mother's name: $mothersName", style = MaterialTheme.typography.bodySmall)
            Text(text = "Category: $category", style = MaterialTheme.typography.bodySmall)
            Text(text = "Date of birth: $dob", style = MaterialTheme.typography.bodySmall)
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Saksham password: $sakshamPassword", style = MaterialTheme.typography.bodySmall)
            Text(text = "Student type: $studentType", style = MaterialTheme.typography.bodySmall)
            Text(text = "Admission Date: $admissionDate", style = MaterialTheme.typography.bodySmall)
            Text(text = "Enrollment no: $enrollmentNo", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.weight(1f))
            BruteButton(onClick = { navController.navigate(ScreenPortal) }, text = "Portal" )
        }
    }

}