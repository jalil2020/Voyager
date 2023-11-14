package com.example.voyager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.voyager.navigation.Navigator
import com.example.voyager.screens.TaskListScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskDetailScreenViewModel @Inject constructor(private val navigator: Navigator) :
    ViewModel() {

    fun back(value: Int) {
        viewModelScope.launch {
            navigator.backResult(TaskListScreen("$value"))
        }
    }
}