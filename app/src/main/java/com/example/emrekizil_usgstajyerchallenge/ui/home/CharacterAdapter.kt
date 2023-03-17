package com.example.emrekizil_usgstajyerchallenge.ui.home

import android.view.ViewGroup
import com.example.emrekizil_usgstajyerchallenge.ui.base.BaseRecyclerViewAdapter

class CharacterAdapter : BaseRecyclerViewAdapter<CharacterHomeUiData,CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.createForm(parent)
    }

}