package com.example.ourdays

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController,
            startDestination = Screen.Home.route
    ){
        composable( route = Screen.Home.route){
            MainScreen(navController = navController)
        }
        composable( route = Screen.AddNews.route){
            AddScreen(navController = navController)
        }
        composable(route = Screen.AddTitle.route){
            AddTextForTitle()
        }
    }
}