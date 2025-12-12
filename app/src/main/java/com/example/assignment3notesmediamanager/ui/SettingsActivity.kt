package com.example.assignment3notesmediamanager.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.assignment3notesmediamanager.R
import com.example.assignment3notesmediamanager.utils.PreferenceHelper

/**
 * Manages user settings for username and theme.
 * This version uses a robust save-then-recreate logic to apply theme changes.
 */
class SettingsActivity : BaseActivity() {

    private lateinit var prefs: PreferenceHelper
    private lateinit var etUsername: EditText
    private lateinit var switchTheme: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Initialize views and preferences
        prefs = PreferenceHelper(this)
        etUsername = findViewById(R.id.etUsername)
        switchTheme = findViewById(R.id.switchTheme)
        val btnSave = findViewById<Button>(R.id.btnSaveSettings)

        // Set the UI to reflect currently saved values
        loadCurrentPreferences()

        // Set the listener for the save button
        btnSave.setOnClickListener {
            saveSettingsAndApplyTheme()
        }
    }

    private fun loadCurrentPreferences() {
        etUsername.setText(prefs.getUsername())
        switchTheme.isChecked = prefs.isDarkMode()
    }

    private fun saveSettingsAndApplyTheme() {
        val originalThemeIsDark = prefs.isDarkMode()
        val newThemeIsDark = switchTheme.isChecked

        // Save all preferences
        prefs.saveUsername(etUsername.text.toString())
        prefs.setDarkMode(newThemeIsDark)

        Toast.makeText(this, "Settings Saved", Toast.LENGTH_SHORT).show()

        // If the theme has actually changed, recreate the activity to apply it
        if (originalThemeIsDark != newThemeIsDark) {
            val mode = if (newThemeIsDark) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
            AppCompatDelegate.setDefaultNightMode(mode)
            // The recreate() call will force the activity to redraw with the new theme.
        }
    }
}
