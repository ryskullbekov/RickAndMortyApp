package com.example.rickandmortyapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.common.Resource
import com.example.rickandmortyapp.data.remote.models.Character
import com.example.rickandmortyapp.databinding.FragmentCharacterBinding
import com.example.rickandmortyapp.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    private val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter: CharacterAdapter = CharacterAdapter()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = characterAdapter
        getData()



    }






    private fun getData() {
        viewModel.fetchCharacters(1).observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    characterAdapter.submitList(it.data?.results)
                }
            }
        })
    }


}