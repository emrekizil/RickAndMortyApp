package com.example.emrekizil_usgstajyerchallenge.ui.home

import androidx.annotation.StringRes
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity

sealed class HomeUiState <out T:Any>{

    object Loading: HomeUiState<Nothing>()
    data class Success<out T:Any>(val data:List<T>): HomeUiState<T>()
    data class Error(@StringRes val message:Int): HomeUiState<Nothing>()
}
