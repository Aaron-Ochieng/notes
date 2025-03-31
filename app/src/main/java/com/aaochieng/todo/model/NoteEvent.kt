package com.aaochieng.todo.model

sealed interface NoteEvent {
    object SaveNote: NoteEvent
    data class SaveTitle(val title : String): NoteEvent
    data class SaveContent(val content : String): NoteEvent
    data class DeleteNote(val note : Note): NoteEvent
}