package com.example.emrekizil_usgstajyerchallenge.domain.usecase.splash

import com.example.emrekizil_usgstajyerchallenge.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAppStateUseCaseImpl @Inject constructor(
    private val repository: RickAndMortyRepository
) : GetAppStateUseCase {
    override suspend fun invoke(): Flow<Boolean> =
        repository.getIsAppFirstOpenState()


}