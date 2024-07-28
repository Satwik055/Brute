package com.ironclad.brute.features.search

import com.ironclad.brute.data.students.domain.model.Student

data class SearchResultState(
    val student: List<Student> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
