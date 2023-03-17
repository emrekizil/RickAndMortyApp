package com.example.emrekizil_usgstajyerchallenge.data.repository

import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.data.dto.character.CharacterResponseItem
import com.example.emrekizil_usgstajyerchallenge.data.dto.locations.Result
import com.example.emrekizil_usgstajyerchallenge.data.mappers.RickAndMortyListMapper
import com.example.emrekizil_usgstajyerchallenge.data.source.RemoteDataSource
import com.example.emrekizil_usgstajyerchallenge.di.IoDispatcher
import com.example.emrekizil_usgstajyerchallenge.domain.module.CharacterEntity
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import com.example.emrekizil_usgstajyerchallenge.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val rickAndMortyListMapper:RickAndMortyListMapper<Result,RickAndMortyEntity>,
    private val characterListMapper:RickAndMortyListMapper<CharacterResponseItem,CharacterEntity>

) : RickAndMortyRepository {
    override suspend fun getLocations(): Flow<NetworkResponseState<List<RickAndMortyEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when(val response = remoteDataSource.getLocations()){
                is NetworkResponseState.Error -> emit(response)
                NetworkResponseState.Loading->Unit
                is NetworkResponseState.Success -> emit(
                    NetworkResponseState.Success(
                        rickAndMortyListMapper.map(
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

}