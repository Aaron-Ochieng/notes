package com.aaochieng.todo.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Upsert // Updating and Inserting
    suspend fun insertNote(note: Note)


    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note")
    fun getAllNotes(): Flow<List<Note>>
}