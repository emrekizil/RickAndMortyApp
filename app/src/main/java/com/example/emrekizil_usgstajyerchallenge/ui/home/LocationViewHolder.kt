package com.example.emrekizil_usgstajyerchallenge.ui.home

import android.graphics.Color
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.emrekizil_usgstajyerchallenge.R
import com.example.emrekizil_usgstajyerchallenge.databinding.ItemLocationBinding
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import com.example.emrekizil_usgstajyerchallenge.ui.base.BaseViewHolder
import com.example.emrekizil_usgstajyerchallenge.utility.inflateAdapterItem

class LocationViewHolder(private val binding:ItemLocationBinding,val onClick:(LocationHomeUiData)->Unit): BaseViewHolder<LocationHomeUiData>(binding.root) {

    private var viewData: LocationHomeUiData? = null
    companion object{
        fun createForm(parent:ViewGroup,onClick: (LocationHomeUiData) -> Unit) =
            LocationViewHolder(parent.inflateAdapterItem(ItemLocationBinding::inflate),onClick)
    }
    init {
        itemView.setOnClickListener {
            viewData?.let { onClick(it) }
            this.binding.locationTextView.background.setTint(Color.parseColor("#ffffff"))
        }
    }
    override fun onBind(data: LocationHomeUiData) {
        binding.locationTextView.text = data.name
        viewData = data
    }
}