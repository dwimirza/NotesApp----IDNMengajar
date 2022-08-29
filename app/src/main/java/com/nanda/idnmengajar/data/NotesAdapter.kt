package com.nanda.idnmengajar.data

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanda.idnmengajar.data.entity.Notes
import com.nanda.idnmengajar.databinding.RowItemJudulBinding

class NotesAdapter(val noteList: List<Notes> ) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    class NotesViewHolder(val binding: RowItemJudulBinding):
        RecyclerView.ViewHolder(binding.root)
}