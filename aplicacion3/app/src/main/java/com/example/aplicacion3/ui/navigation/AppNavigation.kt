package com.example.aplicacion3.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aplicacion3.ui.screens.DetailsScreen
import com.example.aplicacion3.ui.screens.HomeScreen
import com.example.aplicacion3.ui.screens.SettingsScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController = navController) }
        composable("details") { DetailsScreen() }
        composable("settings") { SettingsScreen() }
    }
}