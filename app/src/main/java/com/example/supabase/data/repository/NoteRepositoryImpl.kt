package com.example.supabase.data.repository

import com.example.supabase.data.source.SupabaseDataSource
import com.example.supabase.domain.model.Note
import com.example.supabase.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val supabaseDataSource: SupabaseDataSource
) : NoteRepository {

    override suspend fun getNotes(): List<Note> {
        return supabaseDataSource.getNotes()
    }

    override suspend fun addNote(note: Note) {
        supabaseDataSource.addNote(note)
    }

    override suspend fun deleteNote(id: Long?) {
        if (id != null) {
            supabaseDataSource.deleteNote(id)
        }
    }
}