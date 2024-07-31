package com.ironclad.brute.features.search

import com.ironclad.brute.data.students.domain.model.StudentDto

data class SearchResultState(
    val student: List<StudentDto> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
