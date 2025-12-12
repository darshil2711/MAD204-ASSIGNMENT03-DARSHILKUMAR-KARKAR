/**
 * Course: MAD204-01
 * Assignment: Assignment 3
 * Student: Darshilkumar Karkar (A00203357)
 * Date: 2025-12-12
 * Description: RecyclerView adapter for displaying a list of Note objects.
 */
package com.example.assignment3notesmediamanager.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment3notesmediamanager.R
import com.example.assignment3notesmediamanager.data.Note

class NoteAdapter(
    private val onNoteClick: (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var notes: List<Note> = emptyList()

    /**
     * Provides a reference to the views for each data item.
     */
    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val content: TextView = itemView.findViewById(R.id.tvContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.title.text = note.title
        holder.content.text = note.content
        holder.itemView.setOnClickListener {
            onNoteClick(note)
        }
    }

    override fun getItemCount() = notes.size

    /**
     * Updates the list of notes the adapter is displaying.
     * @param newNotes The new list of notes to display.
     */
    fun submitList(newNotes: List<Note>) {
        notes = newNotes
        notifyDataSetChanged()
    }
}
