package com.example.emrekizil_usgstajyerchallenge.data.mappers

import com.example.emrekizil_usgstajyerchallenge.data.dto.character.CharacterResponseItem
import com.example.emrekizil_usgstajyerchallenge.domain.module.CharacterEntity
import javax.inject.Inject

class CharacterListMapperImpl @Inject constructor() : RickAndMortyListMapper<CharacterResponseItem,CharacterEntity> {
    override fun map(input: List<CharacterResponseItem>?): List<CharacterEntity> {
        return input?.map {
            CharacterEntity(
                created = it.created,
                episode = it.episode,
                gender = it.gender,
                id = it.id,
                image = it.image,
                location = it.location.name,
                name = it.name,
                origin = it.origin.name,
                species = it.species,
                status = it.status
            )
        } ?: emptyList()
    }
}