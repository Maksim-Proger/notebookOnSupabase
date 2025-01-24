package com.example.supabase.domain.repository

import com.example.supabase.domain.model.Note


interface NoteRepository {
    suspend fun getNotes(): List<Note>
    suspend fun addNote(note: Note)
    suspend fun deleteNote(id: Long?)
}