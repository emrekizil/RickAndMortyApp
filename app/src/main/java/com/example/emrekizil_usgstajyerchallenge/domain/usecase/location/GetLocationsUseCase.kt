package com.example.emrekizil_usgstajyerchallenge.domain.usecase.location

import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import kotlinx.coroutines.flow.Flow

interface GetLocationsUseCase {
    suspend operator fun invoke(pageNumber:Int): Flow<NetworkResponseState<List<RickAndMortyEntity>>>
}