package com.example.assignment3notesmediamanager.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.assignment3notesmediamanager.R
import com.example.assignment3notesmediamanager.utils.PreferenceHelper

/**
 * Course: MAD204-01
 * Assignment: Assignment 3
 * Student: Darshilkumar Karkar (A00203357)
 * Date: 2025-12-12
 * Description: Activity to manage user settings.
 */
class SettingsActivity : AppCompatActivity() {
    private lateinit var prefs: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        prefs = PreferenceHelper(this)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val switchTheme = findViewById<Switch>(R.id.switchTheme)
        val btnSave = findViewById<Button>(R.id.btnSaveSettings)

        // Load current values
        etUsername.setText(prefs.getUsername())
        switchTheme.isChecked = prefs.isDarkMode()

        btnSave.setOnClickListener {
            prefs.saveUsername(etUsername.text.toString())
            prefs.setDarkMode(switchTheme.isChecked)

            // Apply Theme
            if (switchTheme.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            Toast.makeText(this, "Settings Saved", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}