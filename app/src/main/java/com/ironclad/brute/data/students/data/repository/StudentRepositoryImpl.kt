package com.ironclad.brute.data.students.data.repository

import com.ironclad.brute.data.students.domain.model.Student
import com.ironclad.brute.data.students.domain.repository.StudentRepository

class StudentRepositoryImpl:StudentRepository{
    override suspend fun searchStudent(query: Student): Student {
        TODO("Not yet implemented")
    }

    override suspend fun getAllStudent(): List<Student> {
        val st1 = Student(studentName = "PHILLIP JEFFER", roll = "2023/0322", course = "Bcom(Hons)|E")
        val st2 = Student(studentName = "ERRIE NICON", roll = "2023/0322", course = "Bcom(Hons)|E")
        val st3 = Student(studentName = "JENIFFER DACOTA", roll = "2023/0322", course = "Bcom(Hons)|E")
        val st4 = Student(studentName = "PHILLIP JEFFER", roll = "2023/0322", course = "Bcom(Hons)|E")
        val st5 = Student(studentName = "NICHOLAS TWEEN", roll = "2023/0322", course = "Bcom(Hons)|E")
        val st6 = Student(studentName = "JEFERY BIGGOT", roll = "2023/0322", course = "Bcom(Hons)|E")
        val st7 = Student(studentName = "LIAN LO LANG", roll = "2023/0322", course = "Bcom(Hons)|E")

        val allStudents  = listOf(st1, st2, st3, st4, st5, st6, st7)

        return allStudents
    }


}