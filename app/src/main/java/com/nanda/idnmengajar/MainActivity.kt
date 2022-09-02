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
import com.nanda.idnmengajar.UpdateNotes.Companion.EXTRA_DATA
import com.nanda.idnmengajar.data.NotesAdapter
import com.nanda.idnmengajar.data.entity.Notes
import com.nanda.idnmengajar.data.network.NotesViewModel
import com.nanda.idnmengajar.databinding.ActivityMainBinding
import com.nanda.idnmengajar.utils.OnItemClickCallback

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding : ActivityMainBinding by viewBinding()
    private val notesAdapter by lazy { NotesAdapter() }
    private val viewModel by viewModels<NotesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            fab.setOnClickListener {
                val intent = Intent(this@MainActivity, TambahNotes::class.java)
                startActivity(intent)
            }
            val mAdapter = NotesAdapter()
            rvJudulNotes.apply {
                viewModel.getAllData().observe(this@MainActivity){ notes ->
                    notesAdapter.setData(notes)
                }
                adapter = notesAdapter
                layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL )
                mAdapter.onItemClickCallback(object : OnItemClickCallback {
                    override fun onItemClicked(notes: Notes) {
                        Toast.makeText(this@MainActivity, "a", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@MainActivity, UpdateNotes::class.java)
                        intent.putExtra(EXTRA_DATA, notes.id)
                        startActivity(intent)
//                        intent
                    }
                })
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