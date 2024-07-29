package com.ironclad.brute.features.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ironclad.brute.data.students.data.repository.exceptions.SearchQueryEmpty
import com.ironclad.brute.data.students.data.repository.StudentRepositoryImpl
import com.ironclad.brute.data.students.data.repository.exceptions.NoResultFound
import com.ironclad.brute.data.students.domain.repository.StudentRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class SearchScreenViewModel:ViewModel() {

    private val repository:StudentRepository = StudentRepositoryImpl()

    private val _searchResultState = mutableStateOf(SearchResultState())
    val searchResultState = _searchResultState

    private val  _searchText = MutableStateFlow("")
    private val  searchText = _searchText.asStateFlow()

    fun onSearchTextChange(text:String){
        _searchText.value = text
        searchStudentByName(searchText)
    }


    @OptIn(FlowPreview::class)
    private fun searchStudentByName(searchText: StateFlow<String>) {
        viewModelScope.launch {
            searchText.debounce(500).collectLatest { input->
                _searchResultState.value = SearchResultState(isLoading = true)
                try{

                    // Names in firestore are stored in lowercase
                    val lowercaseInput = input.lowercase()
                    val student = repository.searchStudentByName(lowercaseInput)
                    when{
                        input.isEmpty() -> throw SearchQueryEmpty()
                        student.isEmpty() -> throw NoResultFound()
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
}