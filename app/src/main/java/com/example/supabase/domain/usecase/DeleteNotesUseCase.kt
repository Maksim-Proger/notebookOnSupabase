package com.example.supabase.domain.usecase

import com.example.supabase.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Long?) {
        if (id != null) {
            repository.deleteNote(id)
        }
    }
}