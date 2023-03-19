package com.example.emrekizil_usgstajyerchallenge.ui.home

import android.view.ViewGroup
import com.example.emrekizil_usgstajyerchallenge.ui.base.BaseRecyclerViewAdapter

class CharacterAdapter(private val onClick:(CharacterHomeUiData)->Unit) : BaseRecyclerViewAdapter<CharacterHomeUiData,CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.createForm(parent)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

}