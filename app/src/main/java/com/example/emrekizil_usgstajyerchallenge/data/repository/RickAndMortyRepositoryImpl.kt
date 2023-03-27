package com.example.emrekizil_usgstajyerchallenge.data.repository

import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.data.dto.character.CharacterResponseItem
import com.example.emrekizil_usgstajyerchallenge.data.dto.locations.Result
import com.example.emrekizil_usgstajyerchallenge.data.mappers.RickAndMortyListMapper
import com.example.emrekizil_usgstajyerchallenge.data.source.remote.RemoteDataSource
import com.example.emrekizil_usgstajyerchallenge.data.source.local.LocalDataSource
import com.example.emrekizil_usgstajyerchallenge.di.IoDispatcher
import com.example.emrekizil_usgstajyerchallenge.domain.entity.CharacterEntity
import com.example.emrekizil_usgstajyerchallenge.domain.entity.LocationEntity
import com.example.emrekizil_usgstajyerchallenge.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource:LocalDataSource,
    private val locationListMapper:RickAndMortyListMapper<Result,LocationEntity>,
    private val characterListMapper:RickAndMortyListMapper<CharacterResponseItem,CharacterEntity>,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RickAndMortyRepository {
    override suspend fun getLocations(pageNumber:Int): Flow<NetworkResponseState<List<LocationEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when(val response = remoteDataSource.getLocations(pageNumber)){
                is NetworkResponseState.Error -> emit(response)
                NetworkResponseState.Loading->Unit
                is NetworkResponseState.Success -> emit(
                    NetworkResponseState.Success(
                        locationListMapper.map(
                            response.result
                        )
                    )
                )
            }
        }.flowOn(ioDispatcher)

    override suspend fun getCharactersById(characterIds: List<String>): Flow<NetworkResponseState<List<CharacterEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when(val response = remoteDataSource.getCharactersById(characterIds)){
                is NetworkResponseState.Error->emit(response)
                NetworkResponseState.Loading->Unit
                is NetworkResponseState.Success->{ emit(
                    NetworkResponseState.Success(
                        characterListMapper.map(
                            response.result
                        )
                    )
                )
                }
            }
        }.flowOn(ioDispatcher)

    override fun getIsAppFirstOpenState(): Flow<Boolean> =
        localDataSource.isAppFirstOpen()

    override suspend fun saveAppFirstOpenState(state:Boolean) {
        localDataSource.saveAppFirstOpen(state)
    }


}