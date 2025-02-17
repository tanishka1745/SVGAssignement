package com.example.svgassignemnt

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
        // Title text
        Text(
            "Random Dog Generator!",
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = 20.sp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // First Button (Generate) navigate to imageGenerator
        Button(
            onClick = { navController.navigate("imageGenerator") },
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(1.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color(66, 134, 244)
            ),
            modifier = Modifier
                .wrapContentWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = "Generate",
                fontSize = 17.sp,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 2.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))


        // This button will navigate us to cacheScreen
        Button(
            onClick = { navController.navigate("cacheScreen") },
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(1.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color(66, 134, 244)
            ),
            modifier = Modifier
                .wrapContentWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = "Show Cached Images",
                fontSize = 17.sp,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 2.dp)
            )
        }
    }
}

