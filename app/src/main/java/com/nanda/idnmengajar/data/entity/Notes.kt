package com.nanda.idnmengajar.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Notes(
    @PrimaryKey
    var id: Int,
    var title: String,
    var description: String,
    var priority: Priority
)
