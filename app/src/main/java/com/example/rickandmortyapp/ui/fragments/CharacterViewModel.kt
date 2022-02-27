package com.example.rickandmortyapp.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    fun fetchCharacters(page: Int) = repository.fetchCharacters(page)


}