package com.ironclad.brute.features.portal

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@Composable
fun SakshamPortalScreen() {

    val viewModel:SakshamPortalViewModel = viewModel()
    val sessionCookieState = viewModel.sessionCookieState.value

    println("Screen: ${sessionCookieState.cookie}")

    Box(
        modifier = Modifier.fillMaxSize()
    ){

        if(sessionCookieState.isLoading){
            Column (
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ){
                CircularProgressIndicator()
                Text(text = "Retrieving user session cookie", color = Color.White)
            }
        }
        if(sessionCookieState.error.isNotBlank()){
            Text(text = sessionCookieState.error)
        }
        if(!sessionCookieState.cookie.isNullOrEmpty()){
            Content(sessionCookie = sessionCookieState.cookie)
        }

    }

}

@SuppressLint("SetJavaScriptEnabled")
@Composable
private fun Content(sessionCookie:String) {

    val url = "https://saksham.sitslive.com/StudentPanel/Pages/Dashboard"
    var isLoading by remember { mutableStateOf(true) }

    val headers = mapOf(
        "accept" to "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
        "accept-language" to "en-GB,en-US;q=0.9,en;q=0.8,hi;q=0.7",
        "cache-control" to "max-age=0",
        "cookie" to "ASP.NET_SessionId=$sessionCookie",
        "referer" to "https://saksham.sitslive.com/StudentPanel/Pages/Dashboard",
        "sec-ch-ua" to "\"Not/A)Brand\";v=\"8\", \"Chromium\";v=\"126\", \"Google Chrome\";v=\"126\"",
        "sec-ch-ua-mobile" to "?0",
        "sec-ch-ua-platform" to "\"Windows\"",
        "sec-fetch-dest" to "document",
        "sec-fetch-mode" to "navigate",
        "sec-fetch-site" to "same-origin",
        "sec-fetch-user" to "?1",
        "upgrade-insecure-requests" to "1",
        "user-agent" to "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36"
    )

    Box (modifier = Modifier.fillMaxSize()){
        AndroidView(
            factory = {
                WebView(it).apply {
                    webViewClient = CustomWebViewClient{ loading-> isLoading = loading}
                    settings.javaScriptEnabled = true
                    settings.loadWithOverviewMode = true
                    settings.useWideViewPort = true
                    settings.setSupportZoom(true)
                    layoutParams =
                        ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                    setSakshamSessionCookie(sessionCookie)
                    loadUrl(url, headers)
                }
            },
        )

        if(isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), color = Color.Red)
        }
    }
}


fun setSakshamSessionCookie(cookie:String){
    val url = "https://saksham.sitslive.com/StudentPanel/Pages/Dashboard"
    val cookieManager = CookieManager.getInstance()

    cookieManager.removeAllCookies(null)
    cookieManager.setCookie(url, "ASP.NET_SessionId=$cookie")
}



    
