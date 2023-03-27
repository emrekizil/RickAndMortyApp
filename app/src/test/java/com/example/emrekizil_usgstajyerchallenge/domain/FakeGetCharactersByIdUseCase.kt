package com.example.emrekizil_usgstajyerchallenge.domain

import com.example.emrekizil_usgstajyerchallenge.apiException
import com.example.emrekizil_usgstajyerchallenge.characterList
import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.domain.entity.CharacterEntity
import com.example.emrekizil_usgstajyerchallenge.domain.usecase.character.GetCharactersByIdUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGetCharactersByIdUseCase : GetCharactersByIdUseCase {

    private var showError = false
    fun updateShowError(showError:Boolean){
        this.showError = showError
    }
    override suspend fun invoke(characterIds: List<String>): Flow<NetworkResponseState<List<CharacterEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            if (showError){
                emit(NetworkResponseState.Error(apiException))
            }else{
                emit(NetworkResponseState.Success(characterList))
            }
        }

}