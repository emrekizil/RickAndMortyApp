package com.example.emrekizil_usgstajyerchallenge.ui.home

import com.example.emrekizil_usgstajyerchallenge.data.mappers.RickAndMortyListMapper
import com.example.emrekizil_usgstajyerchallenge.domain.module.CharacterEntity
import javax.inject.Inject


class CharacterHomeUiMapperImpl @Inject constructor() :RickAndMortyListMapper<CharacterEntity,CharacterHomeUiData> {
    override fun map(input: List<CharacterEntity>?): List<CharacterHomeUiData> {
        return input?.map {
            CharacterHomeUiData(
                created = it.created,
                episode = it.episode,
                gender = it.gender,
                id = it.id,
                image = it.image,
                location = it.location,
                name = it.name,
                origin = it.origin,
                species = it.species,
                status = it.status
            )
        } ?: emptyList()
    }

}