package com.example.emrekizil_usgstajyerchallenge.data.repository

import com.example.emrekizil_usgstajyerchallenge.*
import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.data.mappers.CharacterListMapperImpl
import com.example.emrekizil_usgstajyerchallenge.data.mappers.LocationListMapperImpl
import com.example.emrekizil_usgstajyerchallenge.domain.entity.CharacterEntity
import com.example.emrekizil_usgstajyerchallenge.domain.entity.LocationEntity
import com.example.emrekizil_usgstajyerchallenge.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRepository(
    private val locationMapper:LocationListMapperImpl,
    private val characterMapper:CharacterListMapperImpl
) : RickAndMortyRepository{
    private var testRequest = TestResponseEnum.LOADING

    fun setRequest(testRequest:TestResponseEnum){
        this.testRequest = testRequest
    }
    override suspend fun getLocations(pageNumber: Int): Flow<NetworkResponseState<List<LocationEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when(testRequest){
                TestResponseEnum.LOADING-> emit(NetworkResponseState.Loading)
                TestResponseEnum.ERROR-> emit(NetworkResponseState.Error(Exception("Hata Oluştu")))
                TestResponseEnum.SUCCESS -> emit(NetworkResponseState.Success(locationMapper.map(
                    resultList)))
            }
        }

    override suspend fun getCharactersById(characterIds: List<String>): Flow<NetworkResponseState<List<CharacterEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when(testRequest){
                TestResponseEnum.LOADING -> emit(NetworkResponseState.Loading)
                TestResponseEnum.ERROR -> emit(NetworkResponseState.Error(Exception("Hata Oluştu")))
                TestResponseEnum.SUCCESS -> emit(NetworkResponseState.Success(characterMapper.map(
                    characterResponseItemList
                )))
            }
        }


    override fun getIsAppFirstOpenState(): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun saveAppFirstOpenState(state: Boolean) {
        TODO("Not yet implemented")
    }
}