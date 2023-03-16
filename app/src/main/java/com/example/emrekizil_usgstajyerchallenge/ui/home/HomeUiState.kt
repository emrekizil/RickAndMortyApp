package com.example.emrekizil_usgstajyerchallenge.ui.home

import androidx.annotation.StringRes
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity

sealed class HomeUiState {

    object Loading: HomeUiState()
    data class Success(val data:List<LocationHomeUiData>): HomeUiState()
    data class Error(@StringRes val message:Int): HomeUiState()
}
