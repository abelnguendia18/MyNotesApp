package com.tapondjou.simplenotes

import android.app.Application
import com.tapondjou.simplenotes.db.NoteDatabase
import com.tapondjou.simplenotes.db.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NotesApplication: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { NoteDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { NoteRepository(database.getNoteDao())}
}