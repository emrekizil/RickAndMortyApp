package com.example.emrekizil_usgstajyerchallenge.data.mappers

import com.example.emrekizil_usgstajyerchallenge.data.dto.locations.Result
import com.example.emrekizil_usgstajyerchallenge.domain.entity.LocationEntity
import com.example.emrekizil_usgstajyerchallenge.utility.addCharactersIds
import javax.inject.Inject

class LocationListMapperImpl @Inject constructor() : RickAndMortyListMapper<Result,LocationEntity> {
    override fun map(input: List<Result>?): List<LocationEntity> {
        return input?.map {
            LocationEntity(
                id = it.id,
                name = it.name,
                residents = it.residents.addCharactersIds()
            )
        } ?: emptyList()
    }
}