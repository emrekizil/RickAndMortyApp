package com.example.emrekizil_usgstajyerchallenge.ui.home

import com.example.emrekizil_usgstajyerchallenge.data.mappers.RickAndMortyListMapper
import com.example.emrekizil_usgstajyerchallenge.domain.module.LocationEntity
import javax.inject.Inject

class LocationHomeUiMapperImpl @Inject constructor() : RickAndMortyListMapper<LocationEntity, LocationHomeUiData> {
    override fun map(input: List<LocationEntity>?): List<LocationHomeUiData> {
        return input?.map {
            LocationHomeUiData(
                id = it.id,
                name = it.name,
                residents = it.residents
            )
        } ?: emptyList()
    }

}