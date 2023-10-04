package com.example.voyager.navigation

import kotlinx.coroutines.flow.SharedFlow

interface NavigationDispatcher {
    val dispatcher: SharedFlow<NavigationArgs>
}