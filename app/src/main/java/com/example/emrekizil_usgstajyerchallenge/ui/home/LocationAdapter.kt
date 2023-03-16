package com.example.emrekizil_usgstajyerchallenge.ui.home

import android.view.ViewGroup
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import com.example.emrekizil_usgstajyerchallenge.ui.base.BaseRecyclerViewAdapter

class LocationAdapter(private val onClick:(LocationHomeUiData)->Unit) : BaseRecyclerViewAdapter<LocationHomeUiData,LocationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
       return LocationViewHolder.createForm(parent)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

}