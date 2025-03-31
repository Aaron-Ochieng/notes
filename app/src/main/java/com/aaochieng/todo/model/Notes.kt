package com.aaochieng.todo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime


@Entity
data class Note(
    val title : String,
    val content : String,
    val createdAt : LocalDateTime,
    val color : Long,
    @PrimaryKey(autoGenerate = true) // Room to autogenerate the id
    val id:Int,
)
