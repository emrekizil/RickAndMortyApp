package com.example.emrekizil_usgstajyerchallenge.di

import com.example.emrekizil_usgstajyerchallenge.data.mappers.RickAndMortyListMapper
import com.example.emrekizil_usgstajyerchallenge.data.mappers.RickAndMortyListMapperImpl
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import com.example.emrekizil_usgstajyerchallenge.data.dto.locations.Result
import dagger.Binds
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RickAndMortyMapperModule {
    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyListMapper(rickAndMortyListMapperImpl: RickAndMortyListMapperImpl):RickAndMortyListMapper<Result,RickAndMortyEntity>
}