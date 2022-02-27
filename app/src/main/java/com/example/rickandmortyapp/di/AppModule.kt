package com.example.rickandmortyapp.di

import com.example.rickandmortyapp.data.remote.retrofit.RetrofitClient
import com.example.rickandmortyapp.data.remote.retrofit.apiservice.CharacterApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    private val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideCharacterApiService(): CharacterApiService = retrofitClient
        .provideCharacterApiService()
}