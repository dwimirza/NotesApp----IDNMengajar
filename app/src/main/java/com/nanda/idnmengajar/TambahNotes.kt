package com.nanda.idnmengajar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nanda.idnmengajar.data.entity.Notes
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

                val newNote : Notes = Notes(0,nTitle,nDesc)
                viewModel.insertData(newNote)
                Log.i("TAG", "onCreate: $newNote")
                Toast.makeText(applicationContext,"Succsesfully added new Note",Toast.LENGTH_SHORT).show()
                finish()
            }
        }

    }
}