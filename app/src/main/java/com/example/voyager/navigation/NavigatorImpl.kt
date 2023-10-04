package com.example.voyager.navigation

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
}