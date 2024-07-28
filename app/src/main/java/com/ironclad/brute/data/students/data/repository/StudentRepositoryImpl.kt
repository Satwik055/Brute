package com.ironclad.brute.data.students.data.repository

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import com.ironclad.brute.data.students.domain.model.Student
import com.ironclad.brute.data.students.domain.repository.StudentRepository
import kotlinx.coroutines.tasks.await

class StudentRepositoryImpl:StudentRepository{

    private val studentCollectionRef = Firebase.firestore.collection("Students")

    override suspend fun searchStudent(query: String): Student {
        val student = Student(studentName = "PHILLIP JEFFER", roll = "2023/0322", course = "Bcom(Hons)|E")

        val st1 = Student(studentName = "PHILLIP JEFFER", roll = "2023/0322", course = "Bcom(Hons)|E")
        val st2 = Student(studentName = "ERRIE NICON", roll = "2023/0322", course = "Bcom(Hons)|E")
        val st3 = Student(studentName = "JENIFFER DACOTA", roll = "2023/0322", course = "Bcom(Hons)|E")
        val st4 = Student(studentName = "PHILLIP JEFFER", roll = "2023/0322", course = "Bcom(Hons)|E")
        val st5 = Student(studentName = "NICHOLAS TWEEN", roll = "2023/0322", course = "Bcom(Hons)|E")
        val st6 = Student(studentName = "JEFERY BIGGOT", roll = "2023/0322", course = "Bcom(Hons)|E")
        val st7 = Student(studentName = "LIAN LO LANG", roll = "2023/0322", course = "Bcom(Hons)|E")

        val allStudents  = listOf(st1, st2, st3, st4, st5, st6, st7)

        return student
    }

    override suspend fun getAllStudent(): List<Student> {

        val students = mutableListOf<Student>()
        val querySnapshot = studentCollectionRef.get().await()

        for(document in querySnapshot.documents){
            val student = document.toObject<Student>()
            student?.let { students.add(student) }
        }

        //Filters INVALID_USERNAME
        val filteredStudents = students.filter { it.studentId.isNotEmpty() }

        return filteredStudents
    }

    override suspend fun getStudentById(studentId: String): Student {

        val docSnapshot = studentCollectionRef.whereEqualTo("studentId",studentId).get().await().first()

        if(docSnapshot.exists()){
            return docSnapshot.toObject<Student>()
        }
        throw Exception("Student doesn't exist")
    }
}