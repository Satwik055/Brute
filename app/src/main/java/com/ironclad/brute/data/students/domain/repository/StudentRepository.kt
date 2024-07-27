package com.ironclad.brute.data.students.domain.repository

import com.ironclad.brute.data.students.domain.model.Student

interface StudentRepository {

    suspend fun searchStudent(query:Student):Student

    suspend fun getAllStudent():List<Student>
}