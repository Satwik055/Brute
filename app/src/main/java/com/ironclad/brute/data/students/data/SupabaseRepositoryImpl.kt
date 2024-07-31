package com.ironclad.brute.data.students.data

import com.ironclad.brute.core.utils.Constants
import com.ironclad.brute.data.students.domain.model.StudentDto
import com.ironclad.brute.data.students.domain.repository.StudentRepository
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from

class SupabaseRepositoryImpl:StudentRepository {

    private val supabase = createSupabaseClient(
        supabaseUrl = Constants.SUPABASE_URL,
        supabaseKey = Constants.SUPABASE_ANON_KEY
    ) {
        install(Postgrest)
    }

    override suspend fun searchStudentByName(name: String): List<StudentDto> {
        val result = supabase.from("Student")
            .select{
                filter { ilike("studentName", "$name%") }
            }
        val students = result.decodeList<StudentDto>()
        return students
    }

    override suspend fun getAllStudent(): List<StudentDto> {
        val result = supabase.from("Student")
            .select{
                filter { neq("studentId", "null") }
            }
        val students = result.decodeList<StudentDto>()
        return students
    }

    override suspend fun getStudentById(studentId: String): StudentDto {
        val result = supabase.from("Student")
            .select{
                filter { eq("studentId", studentId) }
            }
        val student = result.decodeSingle<StudentDto>()
        return student
    }
}