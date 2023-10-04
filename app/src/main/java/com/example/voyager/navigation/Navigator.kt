package com.example.voyager.navigation

import cafe.adriel.voyager.androidx.AndroidScreen

typealias NavigationArgs = cafe.adriel.voyager.navigator.Navigator.() -> Unit
typealias AppScreen = AndroidScreen

interface Navigator {
    suspend fun navigateTo(screen: AppScreen)
    suspend fun back()
}