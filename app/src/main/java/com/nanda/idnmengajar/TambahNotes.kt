package com.nanda.idnmengajar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nanda.idnmengajar.databinding.ActivityTambahNotesBinding

class TambahNotes : AppCompatActivity(R.layout.activity_tambah_notes) {

    private val binding : ActivityTambahNotesBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}