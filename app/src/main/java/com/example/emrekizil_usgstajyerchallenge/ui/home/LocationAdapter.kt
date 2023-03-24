package com.example.emrekizil_usgstajyerchallenge.ui.home

import android.graphics.Color
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.emrekizil_usgstajyerchallenge.R
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import com.example.emrekizil_usgstajyerchallenge.ui.base.BaseRecyclerViewAdapter

class LocationAdapter(private val onClick:(LocationHomeUiData)->Unit) : BaseRecyclerViewAdapter<LocationHomeUiData,LocationViewHolder>() {


    private var currentSelection = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
       return LocationViewHolder.createForm(parent,onClick)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        val function = {pos:Int->
            if (currentSelection !=pos){
                currentSelection = pos
                notifyDataSetChanged()
            }
        }
        holder.bindSelectedItem(position,position==currentSelection,function)
    }

}