package com.example.emrekizil_usgstajyerchallenge.domain.usecase.splash

import kotlinx.coroutines.flow.Flow

interface GetAppStateUseCase {
    suspend operator fun invoke() : Flow<Boolean>
}