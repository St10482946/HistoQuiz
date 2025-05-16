// FinalScoreScreen.kt

package com.example.histoquiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FinalScoreScreen(score: Int) {
    // Final screen layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC0CB)), // Pink background
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Congratulatory message
        Text(
            text = "Congratulations!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Display final score
        Text(
            text = "Your Score: $score / 5",
            fontSize = 24.sp
        )
    }
}
