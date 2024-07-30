package com.ironclad.brute.features.portal

data class SessionCookieState(
    val cookie: String? = null,
    val error:String = "",
    val isLoading:Boolean = false
)
