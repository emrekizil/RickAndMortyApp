package com.example.emrekizil_usgstajyerchallenge.di

import com.example.emrekizil_usgstajyerchallenge.data.dto.character.CharacterResponseItem
import com.example.emrekizil_usgstajyerchallenge.data.mappers.RickAndMortyListMapper
import com.example.emrekizil_usgstajyerchallenge.data.mappers.LocationListMapperImpl
import com.example.emrekizil_usgstajyerchallenge.domain.entity.LocationEntity
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import com.example.emrekizil_usgstajyerchallenge.data.dto.locations.Result
import com.example.emrekizil_usgstajyerchallenge.data.mappers.CharacterListMapperImpl
import com.example.emrekizil_usgstajyerchallenge.domain.entity.CharacterEntity
import com.example.emrekizil_usgstajyerchallenge.ui.home.CharacterHomeUiData
import com.example.emrekizil_usgstajyerchallenge.ui.home.mappers.CharacterHomeUiMapperImpl
import com.example.emrekizil_usgstajyerchallenge.ui.home.LocationHomeUiData
import com.example.emrekizil_usgstajyerchallenge.ui.home.mappers.LocationHomeUiMapperImpl
import dagger.Binds
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RickAndMortyMapperModule {
    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyListMapper(locationListMapperImpl: LocationListMapperImpl):RickAndMortyListMapper<Result,LocationEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyLocationUiMapper(locationHomeUiMapperImpl: LocationHomeUiMapperImpl):RickAndMortyListMapper<LocationEntity, LocationHomeUiData>


    @Binds
    @ViewModelScoped
    abstract fun bindCharacterListMapper(characterListMapperImpl: CharacterListMapperImpl):RickAndMortyListMapper<CharacterResponseItem,CharacterEntity>


    @Binds
    @ViewModelScoped
    abstract fun bindCharacterHomeUiMapper(characterHomeUiMapperImpl: CharacterHomeUiMapperImpl):RickAndMortyListMapper<CharacterEntity, CharacterHomeUiData>

}