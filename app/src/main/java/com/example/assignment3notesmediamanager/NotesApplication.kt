// Make sure this package name is correct
package com.example.assignment3notesmediamanager

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.assignment3notesmediamanager.utils.PreferenceHelper


class NotesApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Initialize preference helper
        val prefs = PreferenceHelper(this)

        // Load the saved theme setting and apply it globally
        val isDarkMode = prefs.isDarkMode()
        val mode = if (isDarkMode) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(mode)
    }
}
