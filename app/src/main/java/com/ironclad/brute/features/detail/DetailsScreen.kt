package com.ironclad.brute.features.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ironclad.brute.core.designsystem.components.BruteButton
import com.ironclad.brute.core.designsystem.theme.BruteTheme

@Composable
fun DetailScreen(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        BruteTheme {
            Content(navController = navController)
        }
    }

}

@Composable
private fun Content(modifier: Modifier = Modifier, navController: NavController) {

    val name = "JOHN DOE"
    val roll=  "2023/1213"
    val email = "john123@gmail.com"
    val phone = "9153564577"
    val course = "A"
    val address = ""
    val gender = "Male"
    val fathersName = "John Doe"
    val mothersName = "Jane Doe"
    val admissionDate = "2023-01-01"
    val dob = "1990-01-01"
    val sakshamPassword = "123456"
    val studentId = "1234567890"
    val studentType = "Regular"
    val enrollmentNo = "1234567890"


    Column{
        Text(text = name, style = MaterialTheme.typography.headlineLarge)
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
        Column {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Father's name: $fathersName", style = MaterialTheme.typography.bodySmall)
            Text(text = "Mother's name: $mothersName", style = MaterialTheme.typography.bodySmall)
            Text(text = "Admission Date: $admissionDate", style = MaterialTheme.typography.bodySmall)
            Text(text = "Date of birth: $dob", style = MaterialTheme.typography.bodySmall)
        }
        Column {
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Saksham password: $sakshamPassword", style = MaterialTheme.typography.bodySmall)
            Text(text = "Student ID: $studentId", style = MaterialTheme.typography.bodySmall)
            Text(text = "Student type: $studentType", style = MaterialTheme.typography.bodySmall)
            Text(text = "Enrollment no: $enrollmentNo", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.weight(1f))
            BruteButton(onClick = { /*TODO*/ }, text = "Portal" )
        }
    }

}