package com.example.emrekizil_usgstajyerchallenge.data.repository

import com.example.emrekizil_usgstajyerchallenge.apiException
import com.example.emrekizil_usgstajyerchallenge.characterList
import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.domain.module.CharacterEntity
import com.example.emrekizil_usgstajyerchallenge.domain.module.LocationEntity
import com.example.emrekizil_usgstajyerchallenge.domain.repository.RickAndMortyRepository
import com.example.emrekizil_usgstajyerchallenge.locationList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRepository : RickAndMortyRepository{
    private var showError = false

    override suspend fun getLocations(pageNumber: Int): Flow<NetworkResponseState<List<LocationEntity>>> {
        return flow {
            if(showError){
                NetworkResponseState.Error(apiException)
            }else{
                NetworkResponseState.Success(locationList)
            }
        }
    }

    override suspend fun getCharactersById(characterIds: List<String>): Flow<NetworkResponseState<List<CharacterEntity>>> {
        return flow {
            if(showError){
                NetworkResponseState.Error(apiException)
            }else{
                NetworkResponseState.Success(characterList)
            }
        }
    }

    override fun getIsAppFirstOpenState(): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun saveAppFirstOpenState(state: Boolean) {
        TODO("Not yet implemented")
    }
}