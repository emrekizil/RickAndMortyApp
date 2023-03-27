package com.example.emrekizil_usgstajyerchallenge.domain.repository

import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.domain.entity.CharacterEntity
import com.example.emrekizil_usgstajyerchallenge.domain.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    suspend fun getLocations(pageNumber:Int): Flow<NetworkResponseState<List<LocationEntity>>>

    suspend fun getCharactersById(characterIds:List<String>):Flow<NetworkResponseState<List<CharacterEntity>>>

    fun getIsAppFirstOpenState():Flow<Boolean>

    suspend fun saveAppFirstOpenState(state:Boolean)
}