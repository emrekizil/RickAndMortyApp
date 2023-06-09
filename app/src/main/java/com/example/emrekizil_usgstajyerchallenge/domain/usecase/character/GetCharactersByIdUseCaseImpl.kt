package com.example.emrekizil_usgstajyerchallenge.domain.usecase.character


import com.example.emrekizil_usgstajyerchallenge.data.NetworkResponseState
import com.example.emrekizil_usgstajyerchallenge.domain.entity.CharacterEntity
import com.example.emrekizil_usgstajyerchallenge.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersByIdUseCaseImpl @Inject constructor(
    private val repository: RickAndMortyRepository
) : GetCharactersByIdUseCase {
    override suspend fun invoke(characterIds: List<String>): Flow<NetworkResponseState<List<CharacterEntity>>> = repository.getCharactersById(characterIds)
}