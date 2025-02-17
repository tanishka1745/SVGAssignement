package com.example.simpleviralgameprojectassignment

import android.content.Context
import android.content.SharedPreferences

class LruCache(context: Context, private val maxSize: Int) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("dog_cache", Context.MODE_PRIVATE)
    private val cache = object : LinkedHashMap<String, String>(maxSize, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<String, String>?): Boolean {
            return size > maxSize
        }
    }

    init {
        loadCache()
    }

    fun put(url: String) {
        cache[url] = url
        saveCache()
    }

    fun getAll(): List<String> {
        return cache.values.toList()
    }

    fun clear() {
        cache.clear()
        sharedPreferences.edit().clear().apply()
    }

    private fun saveCache() {
        sharedPreferences.edit().putStringSet("cached_images", cache.keys.toSet()).apply()
    }

    private fun loadCache() {
        val cachedUrls = sharedPreferences.getStringSet("cached_images", emptySet()) ?: emptySet()
        cachedUrls.forEach { cache[it] = it }
    }
}
