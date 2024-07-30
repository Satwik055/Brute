package com.ironclad.brute.features.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ironclad.brute.data.students.data.repository.StudentRepositoryImpl
import com.ironclad.brute.data.students.domain.repository.StudentRepository
import kotlinx.coroutines.launch

class HomeViewModel:ViewModel(){

    //TODO: Add Dependency Injection
    private val studentRepository: StudentRepository = StudentRepositoryImpl()

    private val _allStudentState = mutableStateOf(AllStudentState())
    val allStudentState:State<AllStudentState> = _allStudentState

    init {
        getAllStudent()
    }

    private fun getAllStudent(){
        viewModelScope.launch {
            _allStudentState.value = AllStudentState(isLoading = true)
            try{
                val allStudent = studentRepository.getAllStudent()
                _allStudentState.value = _allStudentState.value.copy(student = allStudent, isLoading = false) }

            catch (e:Exception){
                _allStudentState.value = AllStudentState(error = e.message.toString(), isLoading = false)
            }
        }
    }
}