package com.example.assignment3notesmediamanager.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Course: MAD204-01
 * Assignment: Assignment 3
 * Student: Darshilkumar Karkar (A00203357)
 * Date: 2025-12-12
 * Description: Entity class representing a Note table in Room database.
 */
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val content: String,
    val mediaUri: String? = null,
    val isFavorite: Boolean = false
)