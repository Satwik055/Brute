package com.ironclad.brute.features.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ironclad.brute.data.students.data.repository.exceptions.SearchQueryEmpty
import com.ironclad.brute.data.students.data.repository.StudentRepositoryImpl
import com.ironclad.brute.data.students.data.repository.exceptions.NoResultFound
import com.ironclad.brute.data.students.domain.repository.StudentRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchScreenViewModel:ViewModel() {

    private val repository:StudentRepository = StudentRepositoryImpl()

    private val _searchResultState = mutableStateOf(SearchResultState())
    val searchResultState = _searchResultState

    private val debounceMillis = 500L
    private var searchJob: Job? = null

    fun searchStudentByName(name: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {

            delay(debounceMillis)
            _searchResultState.value = SearchResultState(isLoading = true)
            try{
                val student = repository.searchStudentByName(name)
                when{
                    student.isEmpty() -> throw NoResultFound()
                    name.isBlank() -> throw SearchQueryEmpty()
                }
                _searchResultState.value = SearchResultState(student = student)
            }
            catch (e:Exception){
                _searchResultState.value = SearchResultState(error = e.message.toString())
            }
            catch (e: SearchQueryEmpty){
                _searchResultState.value = SearchResultState()
            }
        }
    }
}