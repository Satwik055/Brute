package com.ironclad.brute.features.home

import com.ironclad.brute.data.students.domain.model.StudentDto

data class AllStudentState(
    val isLoading: Boolean = false,
    val error:String = "",
    val student:List<StudentDto> = emptyList()
)
