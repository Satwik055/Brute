package com.ironclad.brute.features.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ironclad.brute.data.students.data.repository.StudentRepositoryImpl
import com.ironclad.brute.data.students.domain.repository.StudentRepository
import kotlinx.coroutines.launch

class SearchScreenViewModel:ViewModel() {

    private val repository:StudentRepository = StudentRepositoryImpl()

    private val _studentState = mutableStateOf(StudentState())
    val studentState: State<StudentState> = _studentState

    fun searchStudent(query: String) {
        viewModelScope.launch {
            _studentState.value = _studentState.value.copy(isLoading = true)
            try{
                val student = repository.searchStudent(query)
                _studentState.value = _studentState.value.copy(student = student, isLoading = false)
            }
            catch (e:Exception){
                _studentState.value = _studentState.value.copy(error = e.message.toString())

            }
        }


    }


}