package com.example.emrekizil_usgstajyerchallenge.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emrekizil_usgstajyerchallenge.R
import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import com.example.emrekizil_usgstajyerchallenge.domain.usecase.GetLocationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getLocationsUseCase: GetLocationsUseCase
) : ViewModel() {

   private var _locationResponse = MutableLiveData<UiState>()
   val locationResponse :LiveData<UiState> get() = _locationResponse


    fun getLocations() {
        viewModelScope.launch {
            getLocationsUseCase.invoke().collectLatest {response->
                when(response){
                    is NetworkResponseState.Success->{
                        _locationResponse.postValue(response.result?.let { UiState.Success(it) })
                    }
                    is NetworkResponseState.Error ->{
                        _locationResponse.postValue(UiState.Error(R.string.error))
                    }
                    is NetworkResponseState.Loading->{
                        _locationResponse.postValue(UiState.Loading)

                    }
                }

            }
        }
    }


}