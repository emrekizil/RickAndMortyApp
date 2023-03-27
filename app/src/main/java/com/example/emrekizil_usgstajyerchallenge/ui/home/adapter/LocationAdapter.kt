package com.example.emrekizil_usgstajyerchallenge.ui.home.adapter

import android.view.ViewGroup
import com.example.emrekizil_usgstajyerchallenge.ui.base.BaseRecyclerViewAdapter
import com.example.emrekizil_usgstajyerchallenge.ui.home.LocationHomeUiData

class LocationAdapter(private val onClick:(LocationHomeUiData)->Unit) : BaseRecyclerViewAdapter<LocationHomeUiData, LocationViewHolder>() {
    override fun updateItems(newItems:List<LocationHomeUiData>){
        items.apply {
            addAll(newItems)
            notifyDataSetChanged()
        }
    }

    private var currentSelection = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
       return LocationViewHolder.createForm(parent, onClick)
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