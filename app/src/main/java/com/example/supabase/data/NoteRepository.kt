package com.example.supabase.data

import io.github.jan.supabase.postgrest.postgrest

class NoteRepository {

    suspend fun getNotes(): List<Note> {
        return Supabase.client.postgrest["notes"]
            .select()
            .decodeList<Note>()
    }

    suspend fun addNote(note: Note) {
        Supabase.client.postgrest["notes"]
            .insert(note)
    }

    suspend fun deleteNote(id: Long?) { // Принимаем Long?
        if (id != null) { // Проверяем, что id не null
            Supabase.client.postgrest["notes"]
                .delete {
                    filter {
                        eq("id", id) // Теперь id имеет тип Long
                    }
                }
        }
    }
}