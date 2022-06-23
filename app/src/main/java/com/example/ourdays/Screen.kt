package com.example.ourdays

sealed class Screen( val route: String) {
    object Home: Screen( route = "home_screen")
    object AddNews: Screen( route = "add_news")
    object AddTitle: Screen(route = "add_title")

}