package com.ironclad.brute.data.students.data

import com.ironclad.brute.core.utils.Constants
import com.ironclad.brute.data.students.domain.model.StudentDto
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

private val supabase = createSupabaseClient(
    supabaseUrl = Constants.SUPABASE_URL,
    supabaseKey = Constants.SUPABASE_ANON_KEY
) {
    install(Postgrest)
}

suspend fun getAllStudents(): List<StudentDto> {

    val result = supabase.from("Student")
        .select{
            filter { neq("studentId", "null") }
        }
    val students = result.decodeList<StudentDto>()
    return students
}

suspend fun getStudentById(studentId: String): StudentDto {
    val result = supabase.from("Student")
        .select{
            filter { eq("studentId", studentId) }
        }
    val student = result.decodeSingle<StudentDto>()
    return student
}


suspend fun searchStudentByName(studentName:String): List<StudentDto> {
    val result = supabase.from("Student")
        .select{
            filter { ilike("studentName", "$studentName%") }
        }
    val students = result.decodeList<StudentDto>()
    return students
}




fun main(){
    runBlocking {
        val time = measureTimeMillis {
            val students = getAllStudents()
            students.forEach { println(it) }
        }
        println("Time taken: ${time}ms")
    }
}