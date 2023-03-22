package com.example.emrekizil_usgstajyerchallenge.ui.home

import android.view.ViewGroup
import com.example.emrekizil_usgstajyerchallenge.databinding.AdapterCharacterItemBinding
import com.example.emrekizil_usgstajyerchallenge.ui.base.BaseViewHolder
import com.example.emrekizil_usgstajyerchallenge.utility.inflateAdapterItem


class CharacterViewHolder(private val binding:AdapterCharacterItemBinding,val onClick:(CharacterHomeUiData)->Unit):BaseViewHolder<CharacterHomeUiData>(binding.root){

    private var viewData: CharacterHomeUiData? = null
    companion object{
        fun createForm(parent:ViewGroup,onClick: (CharacterHomeUiData) -> Unit)=
            CharacterViewHolder(parent.inflateAdapterItem(AdapterCharacterItemBinding::inflate),onClick)
    }
    init {
        itemView.setOnClickListener {
            viewData?.let { onClick(it) }
        }
    }
    override fun onBind(data: CharacterHomeUiData) {
        binding.characterComponent.setCharacterData(data)
        viewData = data
    }

}