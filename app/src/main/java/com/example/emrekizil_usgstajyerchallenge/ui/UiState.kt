package com.example.emrekizil_usgstajyerchallenge.ui

import androidx.annotation.StringRes
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity

sealed class UiState {

    object Loading:UiState()
    data class Success(val data:List<RickAndMortyEntity>):UiState()
    data class Error(@StringRes val message:Int):UiState()
}