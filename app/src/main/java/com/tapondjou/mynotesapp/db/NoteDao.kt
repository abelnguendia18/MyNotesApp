package com.tapondjou.simplenotes.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNode(note: Note)

    @Query("SELECT * FROM note_table ")
    fun getAllNotes(): Flow<List<Note>>
}