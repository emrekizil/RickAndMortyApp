package com.example.emrekizil_usgstajyerchallenge.domain

import com.example.emrekizil_usgstajyerchallenge.apiException
import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.domain.entity.LocationEntity
import com.example.emrekizil_usgstajyerchallenge.domain.usecase.location.GetLocationsUseCase
import com.example.emrekizil_usgstajyerchallenge.locationList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGetLocationsUseCase : GetLocationsUseCase {
    private var showError = false
    fun updateShowError(showError:Boolean){
        this.showError = showError
    }

    override suspend fun invoke(pageNumber: Int): Flow<NetworkResponseState<List<LocationEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            if (showError){
                emit(NetworkResponseState.Error(apiException))
            }else{
                emit(NetworkResponseState.Success(locationList))
            }
        }

}