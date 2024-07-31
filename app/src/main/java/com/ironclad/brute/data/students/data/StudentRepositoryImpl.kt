package com.ironclad.brute.data.students.data

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.firestore.toObjects
import com.google.firebase.ktx.Firebase
import com.ironclad.brute.data.students.domain.model.StudentDto
import com.ironclad.brute.data.students.domain.repository.StudentRepository
import kotlinx.coroutines.tasks.await

class StudentRepositoryImpl:StudentRepository{

    private val studentCollectionRef = Firebase.firestore.collection("Students")

    override suspend fun searchStudentByName(name: String): List<StudentDto> {
        val querySnapshot = studentCollectionRef.whereGreaterThanOrEqualTo("studentName", name).whereLessThan("studentName",name + "\uf8ff").get().await()
        val students = querySnapshot.toObjects<StudentDto>()
        return students
    }

    override suspend fun getAllStudent(): List<StudentDto> {
        val querySnapshots = studentCollectionRef.whereNotEqualTo("studentId", null).get().await()
        val students = querySnapshots.toObjects<StudentDto>()
        return students
    }

    override suspend fun getStudentById(studentId: String): StudentDto {
        val docSnapshot = studentCollectionRef.whereEqualTo("studentId",studentId).get().await().first()
        val student = docSnapshot.toObject<StudentDto>()
        return student
    }
}