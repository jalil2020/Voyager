package com.example.voyager.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator

class TaskDetailScreen(val id: Int, val text: (String) -> Unit) : AndroidScreen() {
    @Composable
    override fun Content() {
        val count = remember {
            mutableStateOf(0)
        }
        val navigator = LocalNavigator.current
        BackHandler {
            navigator?.replace(TaskListScreen("${count.value}"))
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { count.value++ }) {
                Text(text = "+")
            }
            Text(text = "Count: ${count.value}")
            Button(onClick = { count.value-- }) {
                Text(text = "-")
            }
        }
//        text("${count.value}")
    }
}