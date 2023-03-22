package com.example.emrekizil_usgstajyerchallenge.ui.home

import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.emrekizil_usgstajyerchallenge.R
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import com.example.emrekizil_usgstajyerchallenge.ui.base.BaseRecyclerViewAdapter

class LocationAdapter(private val onClick:(LocationHomeUiData)->Unit) : BaseRecyclerViewAdapter<LocationHomeUiData,LocationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
       return LocationViewHolder.createForm(parent,onClick)
    }

}