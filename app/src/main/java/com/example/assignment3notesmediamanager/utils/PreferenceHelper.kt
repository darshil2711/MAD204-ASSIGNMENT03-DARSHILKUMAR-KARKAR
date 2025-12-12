package com.example.assignment3notesmediamanager.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Course: MAD204-01
 * Assignment: Assignment 3
 * Student: Darshilkumar Karkar (A00203357)
 * Date: 2025-12-12
 * Description: Helper class for SharedPreferences to manage theme and username.
 */
class PreferenceHelper(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    fun saveUsername(name: String) {
        prefs.edit().putString("USERNAME", name).apply()
    }

    fun getUsername(): String? {
        return prefs.getString("USERNAME", "User")
    }

    fun setDarkMode(isDark: Boolean) {
        prefs.edit().putBoolean("DARK_MODE", isDark).apply()
    }

    fun isDarkMode(): Boolean {
        return prefs.getBoolean("DARK_MODE", false)
    }
}