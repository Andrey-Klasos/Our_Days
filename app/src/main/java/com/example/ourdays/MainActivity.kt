package com.example.ourdays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.ourdays.ui.theme.OurDaysTheme



class MainActivity : ComponentActivity() {


    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OurDaysTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}



