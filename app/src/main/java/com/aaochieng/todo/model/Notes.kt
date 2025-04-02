package com.aaochieng.todo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime


@Entity
data class Note(
    val title : String,
    val content : String,
    val createdAt : String,
    val color : String,

    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
)
