package com.nanda.idnmengajar.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nanda.idnmengajar.R
import com.nanda.idnmengajar.data.entity.Notes
import com.nanda.idnmengajar.data.entity.Priority
import com.nanda.idnmengajar.databinding.RowItemJudulBinding
import com.nanda.idnmengajar.utils.OnItemClickCallback

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    private var onItemClickCallback : OnItemClickCallback? = null

    fun onItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    var allNotes = emptyList<Notes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_judul, parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = allNotes[position]
        holder.binding.apply {
            textViewTitle.text = note.title
            textViewDescription.text = note.description

            when (note.priority) {
                Priority.HIGH -> cvNotes.setCardBackgroundColor(cvNotes.context.getColor(R.color.pink))
                Priority.MEDIUM -> cvNotes.setCardBackgroundColor(cvNotes.context.getColor(R.color.yellow))
                Priority.LOW -> cvNotes.setCardBackgroundColor(cvNotes.context.getColor(R.color.green))
            }
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: RowItemJudulBinding by viewBinding()
    }

    fun setData(notes: List<Notes>){
        this.allNotes = notes
        notifyDataSetChanged()
    }
}