/**
 * Course: MAD204-01
 * Assignment: Assignment 3
 * Student: Darshilkumar Karkar (A00203357)
 * Date: 2025-12-12
 * Description: The main screen of the application. It displays a list of all notes
 *              and inherits its settings menu from BaseActivity.
 */
package com.example.assignment3notesmediamanager.ui

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment3notesmediamanager.R
import com.example.assignment3notesmediamanager.data.AppDatabase
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch


class MainActivity : BaseActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ACTION: Find the toolbar and set it as the support action bar
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // --- The rest of your onCreate method remains the same ---
        val fab = findViewById<FloatingActionButton>(R.id.fabAdd)
        fab.setOnClickListener {
            val intent = Intent(this, AddEditNoteActivity::class.java)
            startActivity(intent)
        }

        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        loadNotes()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        noteAdapter = NoteAdapter { note ->
            val intent = Intent(this@MainActivity, AddEditNoteActivity::class.java).apply {
                putExtra("note_id", note.id)
            }
            startActivity(intent)
        }
        recyclerView.adapter = noteAdapter
    }

    private fun loadNotes() {
        lifecycleScope.launch {
            val notes = AppDatabase.getDatabase(applicationContext).noteDao().getAllNotes()
            noteAdapter.submitList(notes)
        }
    }
}
