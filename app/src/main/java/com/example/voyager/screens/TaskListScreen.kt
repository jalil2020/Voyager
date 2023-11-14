package com.example.voyager.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.voyager.viewmodel.TaskListScreenIntent
import com.example.voyager.viewmodel.TaskListScreenIntentUiState
import com.example.voyager.viewmodel.TaskListScreenVIewModel

class TaskListScreen(val x: String? = null) : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<TaskListScreenVIewModel>()
        val uiState = viewModel.uiState.collectAsState()
        TaskListScreenContent(uiState, viewModel::onAction)
    }

    @Composable
    fun TaskListScreenContent(
        uiState: State<TaskListScreenIntentUiState>,
        onAction: (TaskListScreenIntent) -> Unit
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
        ) {
            Button(onClick = {
                onAction(TaskListScreenIntent.NextScreen)
            }) {
                Text(text = "count: ${x ?: "0"}")
            }

        }
    }
}