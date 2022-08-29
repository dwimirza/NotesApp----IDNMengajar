package com.nanda.idnmengajar.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.nanda.idnmengajar.data.entity.Notes

interface NotesDao {
    @Query("SELECT * FROM notes_table")
    fun getData() : List<Notes>

    @Delete()
    suspend fun deleteData(note : Notes)

    @Update()
    suspend fun updateNotes(note : Notes)

    @Insert
    suspend fun insertNotes(note : Notes)

    @Query("SELECT * FROM notes_table WHERE id = :notesId")
    suspend fun getDataId(notesId : Int) : Notes
}