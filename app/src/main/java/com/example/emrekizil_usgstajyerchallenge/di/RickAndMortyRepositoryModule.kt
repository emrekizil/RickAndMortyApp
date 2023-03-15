package com.example.emrekizil_usgstajyerchallenge.di

import com.example.emrekizil_usgstajyerchallenge.data.repository.RickAndMortyRepositoryImpl
import com.example.emrekizil_usgstajyerchallenge.domain.repository.RickAndMortyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RickAndMortyRepositoryModule {
    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyRepository(rickAndMortyRepositoryImpl: RickAndMortyRepositoryImpl):RickAndMortyRepository
}