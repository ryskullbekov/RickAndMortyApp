package com.example.rickandmortyapp

import android.app.Application
import com.example.rickandmortyapp.data.remote.retrofit.RetrofitClient
import com.example.rickandmortyapp.data.remote.retrofit.apiservice.CharacterApiService
import com.example.rickandmortyapp.data.repository.CharacterRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
}