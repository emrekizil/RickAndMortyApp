package com.example.emrekizil_usgstajyerchallenge.domain.usecase.character

import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.domain.module.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface GetCharactersByIdUseCase {
    suspend  operator fun invoke(characterIds:String): Flow<NetworkResponseState<List<CharacterEntity>>>
}
