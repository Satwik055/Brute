package com.ironclad.brute.features.home

import com.ironclad.brute.data.students.domain.model.Student

data class AllStudentState(
    val isLoading: Boolean = false,
    val error:String = "",
    val student:List<Student> = mutableListOf(Student())
)
