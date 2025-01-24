package com.example.supabase.domain.usecase

import com.example.supabase.domain.model.Note
import com.example.supabase.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.addNote(note)
    }
}