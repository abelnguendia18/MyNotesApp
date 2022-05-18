package com.tapondjou.simplenotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tapondjou.mynotesapp.R
import com.tapondjou.simplenotes.db.Note

class NoteListAdapter(var itemClicklistener: onItemClicklistener): ListAdapter<Note, NoteListAdapter.NoteViewHolder>(NotesComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current, itemClicklistener)
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val noteTitleItemView: TextView = itemView.findViewById(R.id.textView_note_title)
        private val noteDescriptionItemView: TextView = itemView.findViewById(R.id.textView_note_description)
        private val notePrio: TextView = itemView.findViewById(R.id.textView_priority)
        private val isChecked: TextView = itemView.findViewById(R.id.textView_is_checked)

        fun bind(note: Note?, clicklistener: onItemClicklistener) {
            if (note != null) {
                noteTitleItemView.text = note.title
            }
            if (note != null) {
                noteDescriptionItemView.text = note.description
            }
            if (note != null) {
                notePrio.text = note.notePrio.toString()
            }
            if (note != null) {

                    isChecked.text = note.isCchecked
            }
            itemView.setOnClickListener{
                if (note != null) {
                    clicklistener.onItemClick(note)
                }
            }
        }

        companion object {
            fun create(parent: ViewGroup): NoteViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return NoteViewHolder(view)
            }
        }
    }

    class NotesComparator : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.title == newItem.title
        }
    }
    interface onItemClicklistener{
        fun onItemClick(note: Note)
    }

}