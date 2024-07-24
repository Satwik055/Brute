package com.ironclad.brute.core.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ironclad.brute.core.SetupNavGraph
import com.ironclad.brute.features.home.HomeScreen
import com.ironclad.brute.features.search.SearchScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetupNavGraph()
        }
    }
}

