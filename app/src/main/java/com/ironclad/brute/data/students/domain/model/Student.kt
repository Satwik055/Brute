package com.ironclad.brute.data.students.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class StudentDto(
    val password: String? = null,
    val studentName: String?  = null,
    val category: String? = null,
    val course:String? = null,
    val phone: String? = null,
    val email: String? = null,
    val roll: String? = null,
    val address: String? = null,
    val fatherName: String? = null,
    val motherName: String? = null,
    val dob: String? = null,
    val gender: String? = null,
    val studentId: String? = null,
    val session: String? = null,
    val studentType: String? = null,
    val enrollmentNo: String? = null,
    val admissionDate: String? = null,
    val timeTaken: String? = null,
)