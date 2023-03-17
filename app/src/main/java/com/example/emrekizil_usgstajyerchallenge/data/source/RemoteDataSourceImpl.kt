package com.example.emrekizil_usgstajyerchallenge.data.source

import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.data.api.RickAndMortyApi
import com.example.emrekizil_usgstajyerchallenge.data.dto.character.CharacterResponseItem
import com.example.emrekizil_usgstajyerchallenge.data.dto.locations.Result
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: RickAndMortyApi) :RemoteDataSource {
    override suspend fun getLocations(): NetworkResponseState<List<Result>> =
        try {
            val response =  api.getLocations()
            NetworkResponseState.Success(response.results)
        }catch (e:Exception){
            NetworkResponseState.Error(e)
        }

    override suspend fun getCharactersById(characterIds: List<String>): NetworkResponseState<List<CharacterResponseItem>> =
        try {
            val response = api.getCharactersById(characterIds)
            NetworkResponseState.Success(response)
        } catch (e: Exception) {
            NetworkResponseState.Error(e)
        }


}