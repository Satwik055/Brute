package com.ironclad.brute.features.portal

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SakshamPortalViewModel:ViewModel() {

    private val _sessionCookieState = mutableStateOf(SessionCookieState())
    val sessionCookieState: State<SessionCookieState> = _sessionCookieState

    init {
        getSessionCookies("2023/0399", "3773")
    }

    private fun getSessionCookies(username:String, password:String){
        viewModelScope.launch {
            _sessionCookieState.value = SessionCookieState(isLoading = true)
            try{
                val cookie = getSessionCookie(username, password)
                println("Viewmodel: $cookie")
                _sessionCookieState.value = SessionCookieState(cookie = cookie)
            }
            catch (e:Exception){
                _sessionCookieState.value = SessionCookieState(error = e.message.toString())
            }
        }
    }
}