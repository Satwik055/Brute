package com.ironclad.brute.features.portal

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient

class CustomWebViewClient(private val onLoadingChanged: (Boolean) -> Unit) : WebViewClient() {
    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        onLoadingChanged(true)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        onLoadingChanged(false)
    }

//    @Deprecated("Deprecated in Java")
//    @Suppress("OverridingDeprecatedMember")
//    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
//        view?.loadUrl(url!!)
//        return true
//    }
}