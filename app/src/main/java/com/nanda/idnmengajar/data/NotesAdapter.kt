package com.nanda.idnmengajar.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nanda.idnmengajar.R
import com.nanda.idnmengajar.data.entity.Notes
import com.nanda.idnmengajar.databinding.RowItemJudulBinding

class NotesAdapter(val noteList: List<Notes>) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_judul, parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = noteList[position]
        holder.binding.apply {
            textViewTitle.text = note.title
            textViewDescription.text = note.description
        }

    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: RowItemJudulBinding by viewBinding()
    }
}