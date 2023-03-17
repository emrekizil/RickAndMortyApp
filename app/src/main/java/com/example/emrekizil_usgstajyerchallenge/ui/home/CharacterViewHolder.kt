package com.example.emrekizil_usgstajyerchallenge.ui.home

import android.view.ViewGroup
import com.example.emrekizil_usgstajyerchallenge.databinding.AdapterCharacterItemBinding
import com.example.emrekizil_usgstajyerchallenge.ui.base.BaseViewHolder
import com.example.emrekizil_usgstajyerchallenge.utility.inflateAdapterItem


class CharacterViewHolder(private val binding:AdapterCharacterItemBinding):BaseViewHolder<CharacterHomeUiData>(binding.root){

    companion object{
        fun createForm(parent:ViewGroup)=
            CharacterViewHolder(parent.inflateAdapterItem(AdapterCharacterItemBinding::inflate))
    }
    override fun onBind(data: CharacterHomeUiData) {
        binding.characterTextView.text = data.name
    }

}