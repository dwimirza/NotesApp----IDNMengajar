package com.nanda.idnmengajar.data.network

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.nanda.idnmengajar.data.NotesRepository
import com.nanda.idnmengajar.data.entity.Notes
import com.nanda.idnmengajar.room.NotesDao
import com.nanda.idnmengajar.room.NotesDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private val notesDao = NotesDatabase.getDatabase(application).NotesDao()
    private val repository: NotesRepository = NotesRepository(notesDao)

    fun getAllData(): LiveData<List<Notes>> = repository.allNotes

    //funsi ini yang akang di gunakan oleh view ketika input data dan dikirimkan ke dalam repository
    fun insertData(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNotes(notes)
        }
    }

    fun deleteAllData(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNotes(notes)
        }
    }

    fun deleteNote(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNotes(notes)
        }
    }

    fun updateNote(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNotes(notes)
        }
    }
}