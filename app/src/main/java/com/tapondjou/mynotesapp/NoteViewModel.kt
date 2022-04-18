package com.tapondjou.simplenotes

import androidx.lifecycle.*
import com.tapondjou.simplenotes.db.Note
import com.tapondjou.simplenotes.db.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(private val noteRepository: NoteRepository): ViewModel() {
    val allNotes: LiveData<List<Note>> = noteRepository.allNotes.asLiveData()

    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.insert(note)
    }

}

class NoteViewModelFactory(private val noteRepository: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(noteRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
