package com.ironclad.brute.data.students.domain.model

import com.google.firebase.firestore.PropertyName


//time_taken -> timeTaken,
//enrollemntNo. -> enrollmentNo,
//admssionDate -> admissionDate,
//worker_node -> workerNode,

//(25.0.0) [CustomClassMapper]: No setter/field for admssionDate found on class com.ironclad.brute.data.students.domain.model.Student

data class Student(
    val password: String = "",
    val studentName: String = "",
    val category: String = "",
    val course:String = "",
    val phone: String = "",
    val email: String = "",
    val roll: String = "",
    val address: String = "",
    val fatherName: String = "",
    val motherName: String = "",
    val dob: String = "",
    val gender: String = "",
    val studentId: String = "",
    val session: String = "",
    val studentType: String = "",
    val enrollmentNo: String = "",
    val admissionDate: String = "",
    val timeTaken: String = "",
)