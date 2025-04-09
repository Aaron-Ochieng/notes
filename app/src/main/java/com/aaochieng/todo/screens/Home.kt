package com.aaochieng.todo.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaochieng.todo.model.NoteEvent
import com.aaochieng.todo.model.NoteState


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
   // state: NoteState,
   // onEvent: (NoteEvent)-> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ){
        padding->
        LazyColumn(
            contentPadding = padding,
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy (16.dp)
        ) {
            item{
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .horizontalScroll(
                            rememberScrollState()
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                ){

                }
            }
        }
    }
}
