/**
 * Course: MAD204-01
 * Assignment: Assignment 3
 * Student: Darshilkumar Karkar (A00203357)
 * Date: 2025-12-12
 * Description: Data Access Object (DAO) for the Note entity. Defines the database operations.
 */
package com.example.assignment3notesmediamanager.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)


    @Query("SELECT * FROM notes ORDER BY id DESC")
    suspend fun getAllNotes(): List<Note>


    @Query("SELECT * FROM notes WHERE isFavorite = 1 ORDER BY id DESC")
    suspend fun getFavoriteNotes(): List<Note>
}
