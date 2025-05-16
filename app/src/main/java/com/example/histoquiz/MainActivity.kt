// MainActivity.kt

package com.example.histoquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Sets the content view using Jetpack Compose
        setContent {
            HistoQuizApp()
        }
    }
}

@Composable
fun HistoQuizApp() {
    val navController = rememberNavController()

    // Navigation host to switch between screens
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("quiz") { QuizScreen(navController) }
        composable("finalScore/{score}") { backStackEntry ->
            // Getting the score passed from the quiz screen
            val score = backStackEntry.arguments?.getString("score")?.toIntOrNull() ?: 0
            FinalScoreScreen(score)
        }
    }
}
