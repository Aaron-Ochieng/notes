package com.aaochieng.todo.model


data class NoteState(
    val notes :List<Note> = emptyList(),
    val title: String = "",
    val content : String = "",
    val searchString : String = "",
    val isSearchActive: Boolean = false

)
