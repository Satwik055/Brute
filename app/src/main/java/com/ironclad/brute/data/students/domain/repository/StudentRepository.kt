package com.ironclad.brute.data.students.domain.repository

import com.ironclad.brute.data.students.domain.model.StudentDto

interface StudentRepository {

    suspend fun searchStudentByName(name:String):List<StudentDto>

    suspend fun getAllStudent():List<StudentDto>

    suspend fun getStudentById(studentId:String): StudentDto
}