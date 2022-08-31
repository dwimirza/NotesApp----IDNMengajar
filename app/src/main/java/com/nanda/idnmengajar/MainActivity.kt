package com.nanda.idnmengajar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nanda.idnmengajar.data.NotesAdapter
import com.nanda.idnmengajar.data.entity.Notes
import com.nanda.idnmengajar.data.network.NotesViewModel
import com.nanda.idnmengajar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding : ActivityMainBinding by viewBinding()
    private val notesAdapter by lazy { NotesAdapter(this) }
    private val viewModel by viewModels<NotesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding.apply {
            fab.setOnClickListener {
                val intent = Intent(this@MainActivity, TambahNotes::class.java)
                startActivity(intent)
            }


            rvJudulNotes.apply {
                viewModel.getAllData().observe(this@MainActivity){ notes ->
                    notesAdapter.setData(notes)
                }
                adapter = notesAdapter
                layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL )
            }
        }




    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
        R.id.sortMenu -> Toast.makeText(applicationContext,"as",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}