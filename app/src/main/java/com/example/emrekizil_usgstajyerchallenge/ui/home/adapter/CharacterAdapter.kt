package com.example.emrekizil_usgstajyerchallenge.ui.home.adapter

import android.view.ViewGroup
import com.example.emrekizil_usgstajyerchallenge.ui.base.BaseRecyclerViewAdapter
import com.example.emrekizil_usgstajyerchallenge.ui.home.CharacterHomeUiData

class CharacterAdapter(private val onClick:(CharacterHomeUiData)->Unit) : BaseRecyclerViewAdapter<CharacterHomeUiData, CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.createForm(parent, onClick)
    }

}