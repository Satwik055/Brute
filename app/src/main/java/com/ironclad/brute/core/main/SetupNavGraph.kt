package com.ironclad.brute.core.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ironclad.brute.features.detail.DetailScreen
import com.ironclad.brute.features.home.HomeScreen
import com.ironclad.brute.features.search.SearchScreen
import kotlinx.serialization.Serializable


@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenHome
    ) {
        composable<ScreenHome>{
            HomeScreen(navController =navController)
        }
        composable<ScreenSearch>{
            SearchScreen(navController = navController)
        }
        composable<ScreenDetail>{
            DetailScreen(navController = navController)
        }
    }
}

@Serializable
object ScreenHome

@Serializable
object ScreenSearch

@Serializable
object ScreenDetail
