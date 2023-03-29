package com.example.emrekizil_usgstajyerchallenge.data.source.local

import kotlinx.coroutines.flow.Flow


interface LocalDataSource {
    fun getIsAppFirstOpenState(): Flow<Boolean>
    suspend fun saveAppFirstOpenState(isFirstOpen:Boolean)
}