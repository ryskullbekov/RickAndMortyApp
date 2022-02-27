package com.example.rickandmortyapp.data.repository

import android.util.Log
import androidx.lifecycle.liveData
import com.example.rickandmortyapp.common.Resource
import com.example.rickandmortyapp.data.remote.retrofit.apiservice.CharacterApiService
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val service: CharacterApiService
) {
    fun fetchCharacters(page: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            Log.e("tag", service.fetchCharacters(page).toString())
            emit(Resource.Success(service.fetchCharacters(page)))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error !", null))
        }
    }

}