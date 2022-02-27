package com.example.rickandmortyapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.data.remote.models.Character
import com.example.rickandmortyapp.databinding.ItemCharacterBinding
import androidx.recyclerview.widget.ListAdapter as ListAdapter


class CharacterAdapter: ListAdapter<Character,CharacterAdapter.ViewHolder>(CharacterDiffutil()) {

    private var list: ArrayList<Character> = ArrayList()



    fun addList(list: ArrayList<Character>?) {
        if (list != null) {
            this.list = list
        }

    }



    class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(character: Character) {
            binding.tvName.text = character.name
            binding.tvStatus.text = character.status
            Glide.with(binding.tvImage).load(character.image).into(binding.tvImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    private class CharacterDiffutil : DiffUtil.ItemCallback<Character>(){
        override fun areItemsTheSame(oldItem: Character, newItem: Character) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Character, newItem: Character) =
            oldItem == newItem

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun getItemCount(): Int = list.size

}