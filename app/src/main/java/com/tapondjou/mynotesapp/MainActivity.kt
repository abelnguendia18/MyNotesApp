package com.tapondjou.mynotesapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.tapondjou.mynotesapp.databinding.ActivityMainBinding
import com.tapondjou.simplenotes.NoteListAdapter
import com.tapondjou.simplenotes.NoteViewModel
import com.tapondjou.simplenotes.NoteViewModelFactory
import com.tapondjou.simplenotes.NotesApplication
import com.tapondjou.simplenotes.db.Note

class MainActivity : AppCompatActivity(), NoteListAdapter.onItemClicklistener {

    private val createNoteActivityRequestCode = 1
    private val noteViewModel: NoteViewModel by viewModels {
        NoteViewModelFactory((application as NotesApplication).repository)
    }
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.my_notes_label)
        val recycleView = binding.recyclerview
        recycleView.setHasFixedSize(true)
        recycleView.layoutManager = LinearLayoutManager(this)
        val adapter = NoteListAdapter(this@MainActivity)
        recycleView.adapter = adapter
        noteViewModel.allNotes.observe(this){ notes ->
            notes.let { adapter.submitList(it) }
        }
        binding.fab.setOnClickListener{
            val intent = Intent(this, CreateNote::class.java)
            startActivityForResult(intent, createNoteActivityRequestCode )
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == createNoteActivityRequestCode && resultCode == Activity.RESULT_OK) {
            val note = intentData?.getSerializableExtra("sendNote") as Note?
            note.let { reply ->
                //val note = Note(reply)
                //wordViewModel.insert(word)
                if (reply != null) {
                    noteViewModel.addNote(reply)
                }

            }
        }
    }

    override fun onItemClick(note: Note) {

        val builder = AlertDialog.Builder(this)
        builder.setTitle(note.title)
        builder.setMessage(note.description)
        builder.setPositiveButton(R.string.validation_text) { dialog, which ->

        }

        builder.setNegativeButton(R.string.cancel_text) { dialog, which ->

        }

        builder.show()

    }

}