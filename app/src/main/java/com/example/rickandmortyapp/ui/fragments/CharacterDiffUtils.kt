package com.example.rickandmortyapp.ui.fragments

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmortyapp.data.remote.models.Character

class CharacterDiffUtils(val oldList: ArrayList<Character>, val newList: ArrayList<Character>): DiffUtil.Callback() {


    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

}