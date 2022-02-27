package com.example.rickandmortyapp.data.remote.retrofit.apiservice

import com.example.rickandmortyapp.data.remote.models.Character
import com.example.rickandmortyapp.data.remote.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character/{id}")
    suspend fun fetchCharacterId(
        @Path("id") id: Int
    ):Character

    @GET("api/character")
   suspend fun fetchCharacters(
        @Query("page") page:Int
    ): RickAndMortyResponse<Character>
}