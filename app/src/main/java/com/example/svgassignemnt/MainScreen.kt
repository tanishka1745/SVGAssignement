package com.example.svgassignemnt

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController




@Composable
fun MainScreen(navController: androidx.navigation.NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Random Dog Generator!",
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = 20.sp) // Set text size to 20sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Primary Button with RGB Color (66, 134, 244) and Black Stroke
        Button(
            onClick = { navController.navigate("imageGenerator") },
            modifier = Modifier
                .wrapContentWidth() // Button width wraps content
                .wrapContentHeight() // Button height wraps content
                .border(2.dp, Color.Black, shape = RoundedCornerShape(8.dp)), // Black border
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(66, 134, 244), // RGB Color for button background
                contentColor = Color.White // White color for button text
            )
        ) {
            Text("Generate")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("cacheScreen") },
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .border(2.dp, Color.Black, shape = RoundedCornerShape(8.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(66, 134, 244),
                contentColor = Color.White
            )
        ) {
            Text("Show Cached Images")
        }



    }
}
