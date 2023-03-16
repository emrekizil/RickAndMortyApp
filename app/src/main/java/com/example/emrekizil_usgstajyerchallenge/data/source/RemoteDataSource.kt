package com.example.emrekizil_usgstajyerchallenge.data.source

import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.data.dto.character.CharacterResponseItem
import com.example.emrekizil_usgstajyerchallenge.data.dto.locations.Result


interface RemoteDataSource {

    suspend fun getLocations(): NetworkResponseState<List<Result>>

    suspend fun getCharactersById(characterIds:String): NetworkResponseState<List<CharacterResponseItem>>
}