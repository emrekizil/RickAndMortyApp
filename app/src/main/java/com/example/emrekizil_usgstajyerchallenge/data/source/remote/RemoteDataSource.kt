package com.example.emrekizil_usgstajyerchallenge.data.source.remote

import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.data.dto.character.CharacterResponseItem
import com.example.emrekizil_usgstajyerchallenge.data.dto.locations.Result


interface RemoteDataSource {

    suspend fun getLocations(pageNumber:Int): NetworkResponseState<List<Result>>

    suspend fun getCharactersById(characterIds:List<String>): NetworkResponseState<List<CharacterResponseItem>>
}