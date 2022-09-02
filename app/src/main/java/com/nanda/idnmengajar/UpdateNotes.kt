package com.nanda.idnmengajar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nanda.idnmengajar.data.network.NotesViewModel
import com.nanda.idnmengajar.databinding.ActivityUpdateNotesBinding
import com.nanda.idnmengajar.utils.OnItemClickCallback

class UpdateNotes : AppCompatActivity(R.layout.activity_update_notes) {

    private val binding: ActivityUpdateNotesBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[NotesViewModel::class.java]


    }

    companion object{
        const val EXTRA_DATA = "extra_data"
    }
}