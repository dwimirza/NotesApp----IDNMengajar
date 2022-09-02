package com.nanda.idnmengajar.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nanda.idnmengajar.data.entity.Notes

@TypeConverters(Converter::class)
@Database(entities = [Notes::class], version = 2, exportSchema = false )
abstract class NotesDatabase : RoomDatabase() {

    abstract fun NotesDao() : NotesDao

    companion object {
        @Volatile
        private var INSTANCE : NotesDatabase? = null

        fun getDatabase(context: Context): NotesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    "notes_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}