package com.example.supabase.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.supabase.domain.model.Note
import com.example.supabase.domain.usecase.AddNoteUseCase
import com.example.supabase.domain.usecase.DeleteNoteUseCase
import com.example.supabase.domain.usecase.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes

    fun loadNotes() {
        viewModelScope.launch {
            _notes.value = getNotesUseCase()
        }
    }

    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            val note = Note(
                title = title,
                content = content
            )
            addNoteUseCase(note)
            loadNotes() // Перезагрузите список заметок после добавления
        }
    }

    fun deleteNote(id: Long?) {
        viewModelScope.launch {
            deleteNoteUseCase(id)
            loadNotes() // Перезагрузите список заметок после удаления
        }
    }
}