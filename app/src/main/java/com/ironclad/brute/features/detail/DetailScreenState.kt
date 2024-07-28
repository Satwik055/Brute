package com.ironclad.brute.features.detail

import com.ironclad.brute.data.students.domain.model.Student

data class DetailScreenState(
    val student: Student = Student(),
    val error: String = "",
    val isLoading: Boolean = false
)
