package com.nanda.idnmengajar.data

import androidx.lifecycle.LiveData
import com.nanda.idnmengajar.data.entity.Notes
import com.nanda.idnmengajar.room.NotesDao

class NotesRepository(private val notesDao : NotesDao) {

    val allNotes : LiveData<List<Notes>> = notesDao.getData()

    suspend fun insertNotes(note : Notes){
        notesDao.insertNotes(note)
    }

    suspend fun deleteNotes(note: Notes){
        notesDao.deleteData(note)
    }

    suspend fun updateNotes(note: Notes){
        notesDao.updateNotes(note)
    }
}