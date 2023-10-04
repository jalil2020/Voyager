package com.example.voyager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.voyager.navigation.Navigator
import com.example.voyager.screens.TaskDetailScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListScreenVIewModel @Inject constructor(private val navigator: Navigator) : ViewModel() {
    val uiState = MutableStateFlow(TaskListScreenIntentUiState(""))

    fun onAction(action: TaskListScreenIntent) {
        when (action) {
            is TaskListScreenIntent.NextScreen -> {
                viewModelScope.launch {
                    navigator.navigateTo(TaskDetailScreen(10))
                }
            }
        }
    }
}