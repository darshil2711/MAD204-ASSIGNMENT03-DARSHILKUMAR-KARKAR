package com.example.assignment3notesmediamanager.ui

import android.net.Uri
import android.os.Bundle
import android.widget.*import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.assignment3notesmediamanager.R
import com.example.assignment3notesmediamanager.data.AppDatabase
import com.example.assignment3notesmediamanager.data.Note
import kotlinx.coroutines.launch

/**
 * Course: MAD204-01
 * Assignment: Assignment 3
 * Student: Darshilkumar Karkar (A00203357)
 * Date: 2025-12-12
 * Description: Activity to add or edit a note, including media picker.
 */
class AddEditNoteActivity : BaseActivity() {

    private var selectedUri: Uri? = null
    private lateinit var ivPreview: ImageView
    private lateinit var getContent: ActivityResultLauncher<String> // Declare the launcher here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)

        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etContent = findViewById<EditText>(R.id.etContent)
        val btnMedia = findViewById<Button>(R.id.btnPickMedia)
        val btnSave = findViewById<Button>(R.id.btnSaveNote)
        val cbFavorite = findViewById<CheckBox>(R.id.cbFavorite)
        ivPreview = findViewById(R.id.ivMediaPreview)

        // Initialize the launcher here, after ivPreview is assigned
        getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                selectedUri = it
                ivPreview.setImageURI(it)
                // Persist permission for the URI
                contentResolver.takePersistableUriPermission(it, android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
        }

        btnMedia.setOnClickListener {
            getContent.launch("image/*") // Launch system picker
        }

        btnSave.setOnClickListener {
            val title = etTitle.text.toString()
            val content = etContent.text.toString()

            if (title.isBlank()) {
                Toast.makeText(this, "Title required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val note = Note(
                title = title,
                content = content,
                mediaUri = selectedUri?.toString(),
                isFavorite = cbFavorite.isChecked
            )

            lifecycleScope.launch {
                AppDatabase.getDatabase(this@AddEditNoteActivity).noteDao().insertNote(note)
                finish()
            }
        }
    }
}

