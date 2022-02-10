package com.tare.dummytabs.di

import com.tare.dummytabs.network.Services
import com.tare.dummytabs.ui.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(services: Services): HomeRepository{
        return HomeRepository(services)
    }
}