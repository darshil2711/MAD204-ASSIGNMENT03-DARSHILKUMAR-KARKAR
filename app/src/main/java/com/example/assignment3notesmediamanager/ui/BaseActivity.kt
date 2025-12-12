/**
 * Course: MAD204-01
 * Assignment: Assignment 3
 * Student: Darshilkumar Karkar (A00203357)
 * Date: 2025-12-12
 * Description: A base activity that provides common functionality, like an options menu
 *              for settings, to all other activities that extend it.
 */
package com.example.assignment3notesmediamanager.ui

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment3notesmediamanager.R


abstract class BaseActivity : AppCompatActivity() {


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true // Indicate that the click was handled
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
