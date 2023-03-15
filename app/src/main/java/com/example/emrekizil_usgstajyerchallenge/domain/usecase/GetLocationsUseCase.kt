package com.example.emrekizil_usgstajyerchallenge.domain.usecase

import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import kotlinx.coroutines.flow.Flow

interface GetLocationsUseCase {
    suspend operator fun invoke(): Flow<NetworkResponseState<List<RickAndMortyEntity>>>
}