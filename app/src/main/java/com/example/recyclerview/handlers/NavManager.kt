package com.example.recyclerview.handlers

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recyclerview.views.CardGame
import com.example.recyclerview.views.final
import com.example.recyclerview.views.inicio

@Composable
fun NavManager() {
    var navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "Inicio") {

        // Rutas
        composable(route = "Inicio") {
            inicio(navController)
        }

        //Lo que queremos que renderice el Nav
        composable(route = "Games/{age}/{budget}", arguments =
        listOf(   //Variables que le pasamos al nav
            navArgument("age") {type = NavType.IntType},
            navArgument("budget") {type = NavType.IntType}
        )) {
                parameters ->
            val age = parameters.arguments?.getInt("age") ?: 0
            val budget = parameters.arguments?.getInt("budget") ?: 0

            CardGame(navController, age, budget)
        }

        composable(route = "Final/{total}", arguments =
        listOf(
            navArgument("total") {type = NavType.IntType}
        )) {
                parameters ->
            val total = parameters.arguments?.getInt("total") ?: 0

            final(navController, total)
        }
    }
}

