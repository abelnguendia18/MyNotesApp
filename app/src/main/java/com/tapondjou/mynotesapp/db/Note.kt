package com.tapondjou.simplenotes.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note_table")
class Note(
    @ColumnInfo(name = "note_title")
    val title: String,
    @ColumnInfo(name = "note_description")
    val description: String,
    @ColumnInfo(name = "note_prio")
    val notePrio: String,
    @ColumnInfo(name = "note_is_checked")
    val isCchecked: String

):Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}