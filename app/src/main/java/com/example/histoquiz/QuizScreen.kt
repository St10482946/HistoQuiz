// QuizScreen.kt

package com.example.histoquiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun QuizScreen(navController: NavController) {
    // Array of questions
    val questions = arrayOf(
        "The Great Wall of China was built to keep out invading Mongol tribes.",
        "The Declaration of Independence was signed in 1776.",
        "Napoleon Bonaparte was a king of France.",
        "World War II ended in 1945.",
        "The Roman Empire fell in the year 1500 AD."
    )

    // Array of answers (true or false)
    val answers = arrayOf(true, true, false, true, false)

    // Track current question index
    var index by remember { mutableStateOf(0) }

    // Track score
    var score by remember { mutableStateOf(0) }

    // Track feedback message
    var feedback by remember { mutableStateOf("") }

    // Main Column Layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC0CB)), // Pink background
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display the current flashcard
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .padding(24.dp)
        ) {
            Text(
                text = questions[index],
                color = Color.White,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // True Button
        Button(onClick = {
            if (answers[index]) {
                feedback = "Good job!"
                score++
            } else {
                feedback = "Oops, almost got it!"
            }
        }) {
            Text("True")
        }

        // False Button
        Button(onClick = {
            if (!answers[index]) {
                feedback = "Good job!"
                score++
            } else {
                feedback = "Oops, almost got it!"
            }
        }) {
            Text("False")
        }

        // Feedback message
        Text(text = feedback, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(20.dp))

        // Navigation Buttons
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            // Back button (disabled if on first question)
            if (index > 0) {
                Button(onClick = { index-- }) {
                    Text("Back")
                }
            }

            Spacer(modifier = Modifier.width(10.dp))

            // Next button (go to next question or final score)
            Button(onClick = {
                if (index < questions.size - 1) {
                    index++
                    feedback = ""
                } else {
                    navController.navigate("finalScore/$score")
                }
            }) {
                Text(if (index == questions.lastIndex) "Finish" else "Next")
            }
        }
    }
}
