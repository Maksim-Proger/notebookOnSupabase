package com.example.supabase.data.source

import com.example.supabase.domain.model.Note
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import javax.inject.Inject

class SupabaseDataSource @Inject constructor(
    private val supabaseClient: SupabaseClient
) {
    suspend fun getNotes(): List<Note> {
        return supabaseClient.postgrest["notes"]
            .select()
            .decodeList()
    }

    suspend fun addNote(note: Note) {
        supabaseClient.postgrest["notes"]
            .insert(note)
    }

    suspend fun deleteNote(id: Long) {
        supabaseClient.postgrest["notes"]
            .delete {
                filter {
                    eq("id", id)
                }
            }
    }
}