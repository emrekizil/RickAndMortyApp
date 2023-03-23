package com.example.emrekizil_usgstajyerchallenge.data.source.local

import kotlinx.coroutines.flow.Flow


interface LocalDataSource {
    fun isAppFirstOpen(): Flow<Boolean>
    suspend fun saveAppFirstOpen(isFirstOpen:Boolean)
}