package com.example.emrekizil_usgstajyerchallenge.domain.repository

import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    suspend fun getLocations(): Flow<NetworkResponseState<List<RickAndMortyEntity>>>
}