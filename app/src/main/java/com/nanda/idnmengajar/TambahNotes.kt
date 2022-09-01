package com.nanda.idnmengajar

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nanda.idnmengajar.data.entity.Notes
import com.nanda.idnmengajar.data.entity.Priority
import com.nanda.idnmengajar.data.network.NotesViewModel
import com.nanda.idnmengajar.databinding.ActivityTambahNotesBinding

class TambahNotes : AppCompatActivity(R.layout.activity_tambah_notes) {

    private val binding: ActivityTambahNotesBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "AddNote"

        val viewModel = ViewModelProvider(this)[NotesViewModel::class.java]

        binding.apply {
            btnAdd.setOnClickListener {
                val nTitle = judul.text.toString()
                val nDesc = deskripsi.text.toString()
                val nPriority = spinnerPriorities.selectedItem.toString()

                val newNote = Notes(0, nTitle, nDesc, parseToPriority(nPriority))
                viewModel.insertData(newNote)
                Log.i("TAG", "onCreate: $newNote")
                Toast.makeText(
                    applicationContext,
                    "Succsesfully added new Note",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }

    private fun parseToPriority(priority: String): Priority {
        val expectedPriority = resources?.getStringArray(R.array.priorities)
        return when (priority) {
            expectedPriority?.get(0) -> Priority.LOW
            expectedPriority?.get(1) -> Priority.MEDIUM
            expectedPriority?.get(2) -> Priority.HIGH
            else -> Priority.LOW
        }
    }
}