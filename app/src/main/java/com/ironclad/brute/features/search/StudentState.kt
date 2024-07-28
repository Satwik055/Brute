package com.ironclad.brute.features.search

import com.ironclad.brute.data.students.domain.model.Student

data class StudentState(
    val student: Student = Student(),
    val error: String = "",
    val isLoading: Boolean = false
)
