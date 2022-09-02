package com.nanda.idnmengajar.room

import androidx.room.TypeConverter
import com.nanda.idnmengajar.data.entity.Priority

// convert type priority (enum class) to store in database and get from database
class Converter {

    // function to get priority from database and convert its become String
    // this function provides data for UI Controller
    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    // function to store priority from UI Controller to database
    // and convert its become Priority
    @TypeConverter
    fun toPriority(string: String): Priority {
        return Priority.valueOf(string)
    }
}