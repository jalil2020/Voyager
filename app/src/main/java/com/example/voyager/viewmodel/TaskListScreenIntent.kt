package com.example.voyager.viewmodel

sealed interface TaskListScreenIntent {
    object NextScreen : TaskListScreenIntent
}