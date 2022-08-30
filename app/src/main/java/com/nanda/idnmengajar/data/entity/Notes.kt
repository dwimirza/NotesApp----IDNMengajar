package com.nanda.idnmengajar.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
//    val priority: Priority
)
