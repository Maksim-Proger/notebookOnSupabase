package com.example.supabase.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.supabase.data.Note
import com.example.supabase.data.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NoteViewModel : ViewModel() {

    private val repository = NoteRepository()
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes

    fun loadNotes() {
        viewModelScope.launch {
            _notes.value = repository.getNotes()
        }
    }

    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            val note = Note(
                title = title,
                content = content
            )
            repository.addNote(note)
            loadNotes() // Перезагрузите список заметок после добавления
        }
    }

    fun deleteNote(id: Long?) { // Принимаем Long?
        viewModelScope.launch {
            if (id != null) { // Проверяем, что id не null
                repository.deleteNote(id)
                loadNotes()
            }
        }
    }
}