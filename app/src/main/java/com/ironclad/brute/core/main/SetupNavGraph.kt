package com.ironclad.brute.core.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ironclad.brute.features.detail.DetailScreen
import com.ironclad.brute.features.home.HomeScreen
import com.ironclad.brute.features.portal.SakshamPortalScreen
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
            val args = it.toRoute<ScreenDetail>()
            DetailScreen(navController = navController, studentId = args.studentId)
        }
        composable<ScreenPortal> {
            SakshamPortalScreen()
        }
    }
}

@Serializable
object ScreenHome

@Serializable
object ScreenSearch

@Serializable
object ScreenPortal


@Serializable
data class ScreenDetail(
    val studentId:String
)
