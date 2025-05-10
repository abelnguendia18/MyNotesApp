package com.tapondjou.mynotesapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
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

        binding.buttonCreateNote.setOnClickListener { view ->
            binding.tvTitleError.visibility = GONE
            binding.tvDescriptionError.visibility = GONE
            val title = binding.edtNoteTitle.text.toString().trim()
            val desc = binding.edtNoteDescription.text.toString().trim()
            val replyIntent = Intent()
            if(title.isEmpty()){
                binding.tvTitleError.visibility = VISIBLE
                binding.edtNoteTitle.requestFocus()
                return@setOnClickListener
            }
            if(desc.isEmpty()){
                binding.tvDescriptionError.visibility = VISIBLE
                binding.edtNoteDescription.requestFocus()
                return@setOnClickListener
            }
                val defect_note = Note( desc,title)
                replyIntent.putExtra("sendNote", defect_note)
                setResult(Activity.RESULT_OK, replyIntent)
                finish()
        }

    }
}