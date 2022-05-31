package com.tapondjou.mynotesapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.tapondjou.mynotesapp.databinding.ActivityCreateNoteBinding
import com.tapondjou.simplenotes.NoteViewModel
import com.tapondjou.simplenotes.NoteViewModelFactory
import com.tapondjou.simplenotes.NotesApplication
import com.tapondjou.simplenotes.db.Note

class CreateNote : AppCompatActivity(), AdapterView.OnItemSelectedListener{

    private val noteViewModel: NoteViewModel by viewModels {
        NoteViewModelFactory((NotesApplication()).repository)
    }
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityCreateNoteBinding
    private lateinit var priority_spinner: Spinner
    private lateinit var checkBoxState: CheckBox
    var prioValue: String  ="1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.new_note_label)
        checkBoxState = binding.checkBoxColor
        priority_spinner = binding.spinnerForPriority
        ArrayAdapter.createFromResource(
            this,
            R.array.priority_values,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            priority_spinner.adapter = adapter
        }
        priority_spinner.onItemSelectedListener = this


        binding.buttonCreateNote.setOnClickListener {view ->
            //findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            //Snackbar.make(view,"", Snackbar.LENGTH_LONG).show()
            val title = binding.edtNoteTitle.text.toString().trim()
            val desc = binding.edtNoteDescription.text.toString().trim()
            var checkBoxValue = ""
            if(checkBoxState.isChecked){
                checkBoxValue = applicationContext.getString(R.string.label_checkbox_checked)
            }else{
                checkBoxValue = applicationContext.getString(R.string.label_checkbox_not_checked)
            }
            val replyIntent = Intent()
            if(title.isEmpty()){
                //binding.edtNoteTitle.error = getString(R.string.error_title_label)
                Toast.makeText(this, getString(R.string.error_title_label), Toast.LENGTH_LONG).show()
                binding.edtNoteTitle.requestFocus()
                return@setOnClickListener
            }
            if(desc.isEmpty()){
                //binding.edtNoteDescription.error = getString(R.string.error_description_label)
                Toast.makeText(this, getString(R.string.error_description_label), Toast.LENGTH_LONG).show()

                binding.edtNoteDescription.requestFocus()
                return@setOnClickListener
            }
                val note = Note(title, desc, prioValue, checkBoxValue)
                //val defect_note = Note( desc,title)
                replyIntent.putExtra("sendNote", note)
                setResult(Activity.RESULT_OK, replyIntent)
                finish()

        }

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
        prioValue = parent.getItemAtPosition(pos) as String
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }


}