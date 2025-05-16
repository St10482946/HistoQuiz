// WelcomeScreen.kt

package com.example.histoquiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun WelcomeScreen(navController: NavController) {
    // Column layout to stack elements vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC0CB)), // Pink background
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        // App name
        Text(
            text = "HistoQuiz",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(30.dp))

        // App description
        Text(
            text = "Test your history knowledge with Flashcards! This app helps you study in a fun way!",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(100.dp))

        // Start button
        Button(
            onClick = { navController.navigate("quiz") },
            modifier = Modifier.padding(20.dp)
        ) {
            Text("Start Quiz")
        }
    }
}
