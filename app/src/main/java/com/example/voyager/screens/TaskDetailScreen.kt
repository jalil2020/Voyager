package com.example.voyager.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.androidx.AndroidScreen

class TaskDetailScreen(val id: Int) : AndroidScreen() {
    @Composable
    override fun Content() {
        Text(text = "$id")

    }
}