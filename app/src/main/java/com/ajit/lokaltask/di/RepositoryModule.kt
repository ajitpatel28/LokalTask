package com.ajit.lokaltask.di

import android.app.Application
import android.content.Context
import com.ajit.lokaltask.data.remote.ApiService
import com.ajit.lokaltask.data.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providePostRepository(apiService: ApiService): ProductRepository {
        return ProductRepository(apiService)
    }

}