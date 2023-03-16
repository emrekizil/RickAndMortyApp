package com.example.emrekizil_usgstajyerchallenge.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emrekizil_usgstajyerchallenge.R
import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.data.mappers.RickAndMortyListMapper
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import com.example.emrekizil_usgstajyerchallenge.domain.usecase.location.GetLocationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLocationsUseCase: GetLocationsUseCase,
    private val rickAndMortyListMapper: RickAndMortyListMapper<RickAndMortyEntity,LocationHomeUiData>
) : ViewModel() {

    private var _locationResponse = MutableLiveData<HomeUiState>()
    val locationResponse:LiveData<HomeUiState> get() = _locationResponse


    fun getLocations(){
        viewModelScope.launch {
            getLocationsUseCase.invoke().collectLatest { response->
                when(response){
                    is NetworkResponseState.Success->{
                        _locationResponse.postValue(HomeUiState.Success(rickAndMortyListMapper.map(response.result)))
                    }
                    is NetworkResponseState.Error ->{
                        _locationResponse.postValue(HomeUiState.Error(R.string.error))
                    }
                    is NetworkResponseState.Loading->{
                        _locationResponse.postValue(HomeUiState.Loading)
                    }
                }
            }
        }
    }

}