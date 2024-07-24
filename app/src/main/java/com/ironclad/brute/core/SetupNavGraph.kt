package com.ironclad.brute.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ironclad.brute.features.home.HomeScreen
import com.ironclad.brute.features.search.SearchScreen
import kotlinx.serialization.Serializable


@Composable
fun SetupNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenHome
    ) {
        composable<ScreenHome>{
            HomeScreen(modifier = modifier, navController)
        }
        composable<ScreenSearch>{
            SearchScreen(modifier = modifier, navController)
        }
    }
}

@Serializable
object ScreenHome

@Serializable
object ScreenSearch


