package com.example.emrekizil_usgstajyerchallenge.domain.usecase.location

import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.domain.entity.LocationEntity
import com.example.emrekizil_usgstajyerchallenge.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocationsUseCaseImpl @Inject constructor(
    private val repository: RickAndMortyRepository
) : GetLocationsUseCase {
    override suspend fun invoke(pageNumber:Int): Flow<NetworkResponseState<List<LocationEntity>>> =
        repository.getLocations(pageNumber)
}