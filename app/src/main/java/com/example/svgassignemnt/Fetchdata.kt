package com.example.simpleviralgameprojectassignment


import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun fetchDogImage(): String? {
    return withContext(Dispatchers.IO) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://dog.ceo/api/breeds/image/random")
            .build()

        try {
            val response = client.newCall(request).execute()
            val responseBody = response.body?.string()

            responseBody?.let {
                JSONObject(it).getString("message")
            }
        } catch (e: Exception) {
            null
        }
    }
}
