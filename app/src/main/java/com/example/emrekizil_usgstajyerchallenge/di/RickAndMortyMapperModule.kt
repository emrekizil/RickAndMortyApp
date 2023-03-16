package com.example.emrekizil_usgstajyerchallenge.di

import com.example.emrekizil_usgstajyerchallenge.data.dto.character.CharacterResponseItem
import com.example.emrekizil_usgstajyerchallenge.data.mappers.RickAndMortyListMapper
import com.example.emrekizil_usgstajyerchallenge.data.mappers.RickAndMortyListMapperImpl
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import com.example.emrekizil_usgstajyerchallenge.data.dto.locations.Result
import com.example.emrekizil_usgstajyerchallenge.data.mappers.CharacterListMapperImpl
import com.example.emrekizil_usgstajyerchallenge.data.mappers.RickAndMortyMapper
import com.example.emrekizil_usgstajyerchallenge.domain.module.CharacterEntity
import com.example.emrekizil_usgstajyerchallenge.ui.home.LocationHomeUiData
import com.example.emrekizil_usgstajyerchallenge.ui.home.LocationHomeUiMapperImpl
import dagger.Binds
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RickAndMortyMapperModule {
    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyListMapper(rickAndMortyListMapperImpl: RickAndMortyListMapperImpl):RickAndMortyListMapper<Result,RickAndMortyEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyLocationUiMapper(locationHomeUiMapperImpl: LocationHomeUiMapperImpl):RickAndMortyListMapper<RickAndMortyEntity,LocationHomeUiData>


    @Binds
    @ViewModelScoped
    abstract fun bindCharacterListMapper(characterListMapperImpl: CharacterListMapperImpl):RickAndMortyListMapper<CharacterResponseItem,CharacterEntity>
}