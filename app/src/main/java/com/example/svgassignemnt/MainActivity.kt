package com.example.svgassignemnt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simpleviralgameprojectassignment.CacheActivity
import com.example.simpleviralgameprojectassignment.ImageGeneratorActivity
import com.example.simpleviralgameprojectassignment.LruCache
import com.example.svgassignemnt.ui.theme.SVGAssignemntTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cache = LruCache(this, 20)
        setContent {
            val navController = rememberNavController()
            AppNavigation(navController, cache)
        }
    }
}

// Use NavController to Navigate in between Multiple Screen
@Composable
fun AppNavigation(navController: androidx.navigation.NavHostController, cache: LruCache) {
    NavHost(navController, startDestination = "mainScreen") {
        composable("mainScreen") { MainScreen(navController) }
        composable("imageGenerator") { ImageGeneratorActivity(cache, navController) }
        composable("cacheScreen") { CacheActivity(cache,navController) }
    }
}