package com.example.emrekizil_usgstajyerchallenge.data.mappers

import com.example.emrekizil_usgstajyerchallenge.data.dto.locations.Result
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import javax.inject.Inject

class RickAndMortyListMapperImpl @Inject constructor() : RickAndMortyListMapper<Result,RickAndMortyEntity> {
    override fun map(input: List<Result>?): List<RickAndMortyEntity> {
        return input?.map {
            RickAndMortyEntity(
                id = it.id,
                name = it.name,
                residents = it.residents
            )
        } ?: emptyList()
    }
}