package com.example.emrekizil_usgstajyerchallenge.domain.usecase

import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import com.example.emrekizil_usgstajyerchallenge.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocationsUseCaseImpl @Inject constructor(
    private val repository: RickAndMortyRepository
) : GetLocationsUseCase{
    override suspend fun invoke(): Flow<NetworkResponseState<List<RickAndMortyEntity>>> = repository.getLocations()
}