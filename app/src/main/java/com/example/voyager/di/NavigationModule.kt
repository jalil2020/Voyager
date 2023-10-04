package com.example.voyager.di

import com.example.voyager.navigation.NavigationDispatcher
import com.example.voyager.navigation.Navigator
import com.example.voyager.navigation.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun provideNavigator(impl: NavigatorImpl): Navigator

    @Binds
    fun provideNavigationDispatcher(impl: NavigatorImpl): NavigationDispatcher
}