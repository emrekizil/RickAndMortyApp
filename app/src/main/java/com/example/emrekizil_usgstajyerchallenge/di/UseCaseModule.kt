package com.example.emrekizil_usgstajyerchallenge.di

import com.example.emrekizil_usgstajyerchallenge.domain.usecase.GetLocationsUseCase
import com.example.emrekizil_usgstajyerchallenge.domain.usecase.GetLocationsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetLocationsUseCase(getLocationsUseCaseImpl: GetLocationsUseCaseImpl):GetLocationsUseCase

}