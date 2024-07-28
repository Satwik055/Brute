package com.ironclad.brute.data.students.domain.repository

import com.ironclad.brute.data.students.domain.model.Student

interface StudentRepository {

    suspend fun searchStudent(query:String):Student

    suspend fun getAllStudent():List<Student>

    suspend fun getStudentById(id:String):Student
}