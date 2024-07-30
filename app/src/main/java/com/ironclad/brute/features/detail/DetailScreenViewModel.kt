package com.ironclad.brute.features.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.ironclad.brute.data.students.data.repository.StudentRepositoryImpl
import com.ironclad.brute.data.students.data.repository.exceptions.StudentNotFound
import com.ironclad.brute.data.students.domain.repository.StudentRepository
import kotlinx.coroutines.launch

class DetailScreenViewModel:ViewModel() {

    private val repository: StudentRepository = StudentRepositoryImpl()

    private val _detailScreenState = mutableStateOf(DetailScreenState())
    val detailScreenState:State<DetailScreenState> = _detailScreenState

    fun getStudentById(studentId:String){
        viewModelScope.launch {

            _detailScreenState.value = DetailScreenState(isLoading = true)
            try {
                val student = repository.getStudentById(studentId)
                when{
                    student.studentId.isEmpty() -> throw StudentNotFound()
                }
                _detailScreenState.value = DetailScreenState(student = student)
            }
            catch (e:Exception){
                _detailScreenState.value = DetailScreenState(error = e.message.toString())
            }
        }
    }
}