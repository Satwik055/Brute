package com.ironclad.brute.data.students.domain.repository

import com.ironclad.brute.data.students.domain.model.Student

interface StudentRepository {

    suspend fun searchStudentByName(name:String):List<Student>

    suspend fun getAllStudent():List<Student>

    suspend fun getStudentById(studentId:String):Student
}