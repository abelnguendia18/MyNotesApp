package com.tapondjou.mynotesapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.tapondjou.mynotesapp.databinding.ActivityCreateNoteBinding
import com.tapondjou.simplenotes.NoteViewModel
import com.tapondjou.simplenotes.NoteViewModelFactory
import com.tapondjou.simplenotes.NotesApplication
import com.tapondjou.simplenotes.db.Note

class CreateNote : AppCompatActivity() {

    private val noteViewModel: NoteViewModel by viewModels {
        NoteViewModelFactory((NotesApplication()).repository)
    }
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityCreateNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.new_note_label)

        binding.buttonCreateNote.setOnClickListener {view ->
            //findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            //Snackbar.make(view,"", Snackbar.LENGTH_LONG).show()
            val title = binding.edtNoteTitle.text.toString().trim()
            val desc = binding.edtNoteDescription.text.toString().trim()
            val replyIntent = Intent()
            if(title.isEmpty()){
                //binding.edtNoteTitle.error = getString(R.string.error_title_label)
                binding.edtNoteTitle.requestFocus()
                return@setOnClickListener
            }
            if(desc.isEmpty()){
                //binding.edtNoteDescription.error = getString(R.string.error_description_label)
                binding.edtNoteDescription.requestFocus()
                return@setOnClickListener
            }
                val note = Note(title, desc)
                replyIntent.putExtra("sendNote", note)
                setResult(Activity.RESULT_OK, replyIntent)
                finish()

        }

    }
}