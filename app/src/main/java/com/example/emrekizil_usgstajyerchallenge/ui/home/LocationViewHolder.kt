package com.example.emrekizil_usgstajyerchallenge.ui.home

import android.view.ViewGroup
import com.example.emrekizil_usgstajyerchallenge.databinding.ItemLocationBinding
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import com.example.emrekizil_usgstajyerchallenge.ui.base.BaseViewHolder
import com.example.emrekizil_usgstajyerchallenge.utility.inflateAdapterItem

class LocationViewHolder(private val binding:ItemLocationBinding): BaseViewHolder<LocationHomeUiData>(binding.root) {

    companion object{
        fun createForm(parent:ViewGroup) =
            LocationViewHolder(parent.inflateAdapterItem(ItemLocationBinding::inflate))
    }

    override fun onBind(data: LocationHomeUiData) {
        binding.locationTextView.text = data.name
    }
}