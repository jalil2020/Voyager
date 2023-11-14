package com.example.voyager.navigation

import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorImpl @Inject constructor() : Navigator, NavigationDispatcher {
    override val dispatcher = MutableSharedFlow<NavigationArgs>()

    private suspend fun navigate(screen: NavigationArgs) {
        dispatcher.emit(screen)
    }

    override suspend fun navigateTo(screen: AppScreen) = navigate {
        push(screen)
    }

    override suspend fun back() = navigate {
        pop()
    }

    override suspend fun backResult(screen: AppScreen) = navigate {
        val l = arrayListOf<Screen>()
        l.addAll(items)
        l.removeAt(1)
        l.removeAt(0)
        l.add(screen)
        replaceAll(l)
    }
}