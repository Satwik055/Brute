package com.ironclad.brute.features.detail

import com.ironclad.brute.data.students.domain.model.StudentDto

data class DetailScreenState(
    val student: StudentDto? = null,
    val error: String = "",
    val isLoading: Boolean = false
)
