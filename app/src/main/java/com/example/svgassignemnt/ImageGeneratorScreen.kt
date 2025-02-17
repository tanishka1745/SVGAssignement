package com.example.simpleviralgameprojectassignment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter


import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageGeneratorActivity(cache: LruCache, navController: androidx.navigation.NavHostController) {
    val dogImageUrl = remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Generate Dogs!",
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp)
                    )
                }
            },
            navigationIcon = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                    Text(
                        text = "Back",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 14.sp,
                            color = Color(66, 134, 244) // RGB color for "Back" text
                        ),
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            },
            modifier = Modifier.height(56.dp),
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(211, 211, 211))
        )

        Spacer(modifier = Modifier.height(24.dp)) // Adjust space below AppBar

        dogImageUrl.value?.let {
            Image(
                painter = rememberAsyncImagePainter(it),
                contentDescription = "Dog Image",
                modifier = Modifier
                    .size(250.dp) // Adjust size as needed
                    .align(Alignment.CenterHorizontally) // Center the image horizontally
                    .clip(RoundedCornerShape(16.dp))
                    .border(2.dp, Color.Black, shape = RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        // Space between image and button
        Spacer(modifier = Modifier.height(32.dp))


        Button(
            onClick = {
                scope.launch {
                    val imageUrl = fetchDogImage()
                    if (imageUrl != null) {
                        dogImageUrl.value = imageUrl
                        cache.put(imageUrl)
                    }
                }
            },
            modifier = Modifier
                .height(40.dp) // Button height
                .align(Alignment.CenterHorizontally) // Center the button horizontally
                .border(2.dp, Color.Black, shape = RoundedCornerShape(8.dp)), // Black border
            colors = ButtonDefaults.buttonColors(containerColor = Color(66, 134, 244), contentColor = Color.White) // RGB Color
        ) {
            Text("Generate")
        }
    }
}


