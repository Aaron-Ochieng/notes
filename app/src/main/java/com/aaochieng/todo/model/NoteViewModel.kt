package com.aaochieng.todo.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class NoteViewModel(
    private val dao: NoteDao
): ViewModel(

) {
    private val _state = MutableStateFlow(NoteState())
    val state = _state.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NoteState())

    val uicolors = listOf<String>(
        "0xFFFF7BBF",
        "0xFFFFE3B3",
        "0xFFF64668",
        "0xFF557B83",
        "0xFFFE72A9"
    )

    //
    fun onEvent(event: NoteEvent){
        when(event){
            is NoteEvent.DeleteNote->{
                viewModelScope.launch {
                    dao.deleteNote(event.note)
                }
            }

            is NoteEvent.SaveContent -> {
               _state.update {
                   it.copy(
                       content = event.content
                   )
               }
            }
            NoteEvent.SaveNote -> {
                val title = state.value.title
                val content = state.value.content

                if (title.isEmpty() || content.isEmpty()){
                    return
                }
                val note = Note(
                    title = title,
                    content = content,
                    color = uicolors.random(),
                    createdAt = LocalDateTime.now()
                )
                viewModelScope.launch {
                    dao.insertNote(note)
                }
            }
            is NoteEvent.SaveTitle -> {
                _state.update {
                    it.copy(
                        title = event.title
                    )
                }
            }
        }
    }
}