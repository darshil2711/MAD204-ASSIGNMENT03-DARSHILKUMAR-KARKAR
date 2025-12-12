/**
 * Course: MAD204-01
 * Assignment: Assignment 3
 * Student: Darshilkumar Karkar (A00203357)
 * Date: 2025-12-12
 * Description: A helper class to manage reading from and writing to SharedPreferences.
 */
package com.example.assignment3notesmediamanager.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Handles all operations related to SharedPreferences, providing a clean
 * API for storing and retrieving user settings like username and theme preference.
 *
 * @param context The application context, used to get an instance of SharedPreferences.
 */
class PreferenceHelper(context: Context) {

    // Constants for SharedPreferences keys
    companion object {
        private const val PREFS_NAME = "AppPrefs"
        private const val KEY_USERNAME = "username"
        private const val KEY_DARK_MODE = "isDarkMode"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    /**
     * Saves the user's name to SharedPreferences.
     * @param username The username string to save.
     */
    fun saveUsername(username: String) {
        sharedPreferences.edit().putString(KEY_USERNAME, username).apply()
    }

    /**
     * Retrieves the saved username from SharedPreferences.
     * @return The saved username, or a default string "User" if none is found.
     */
    fun getUsername(): String {
        return sharedPreferences.getString(KEY_USERNAME, "User") ?: "User"
    }

    /**
     * Saves the user's theme preference (dark or light mode).
     * @param isDarkMode True if dark mode is enabled, false otherwise.
     */
    fun setDarkMode(isDarkMode: Boolean) {
        sharedPreferences.edit().putBoolean(KEY_DARK_MODE, isDarkMode).apply()
    }

    /**
     * Retrieves the saved theme preference.
     * @return True if dark mode is enabled, defaults to false (light mode).
     */
    fun isDarkMode(): Boolean {
        return sharedPreferences.getBoolean(KEY_DARK_MODE, false)
    }
}
