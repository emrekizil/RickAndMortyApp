package com.example.emrekizil_usgstajyerchallenge.ui.home

import com.example.emrekizil_usgstajyerchallenge.data.mappers.RickAndMortyListMapper
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import com.example.emrekizil_usgstajyerchallenge.utility.addCharactersIds
import javax.inject.Inject

class LocationHomeUiMapperImpl @Inject constructor() : RickAndMortyListMapper<RickAndMortyEntity, LocationHomeUiData> {
    override fun map(input: List<RickAndMortyEntity>?): List<LocationHomeUiData> {
        return input?.map {
            LocationHomeUiData(
                id = it.id,
                name = it.name,
                residents = it.residents.addCharactersIds()
            )
        } ?: emptyList()
    }

}