package com.ironclad.brute.data.students.data.repository

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.ktx.Firebase
import com.ironclad.brute.data.students.domain.model.Student
import com.ironclad.brute.data.students.domain.repository.StudentRepository
import kotlinx.coroutines.tasks.await

class StudentRepositoryImpl:StudentRepository{

    private val studentCollectionRef = Firebase.firestore.collection("Students")

    override suspend fun searchStudentByName(name: String): List<Student> {

        val result = mutableListOf<Student>()

        val querySnapshot = studentCollectionRef.whereGreaterThanOrEqualTo("studentName", name).whereLessThan("studentName",name + "\uf8ff").get().await()
        val docSnapshots = querySnapshot.documents

        for(document in docSnapshots){
            val student = document.toObject<Student>()
            student?.let {
                result.add(student)
            }
        }
        return result
    }


    override suspend fun getAllStudent(): List<Student> {

        val students = mutableListOf<Student>()
        val querySnapshot = studentCollectionRef.get().await()
        val docSnapshot = querySnapshot.documents

        for(document in docSnapshot){
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
            val student = docSnapshot.toObject<Student>()
            return student
        }
        return Student()
    }
}