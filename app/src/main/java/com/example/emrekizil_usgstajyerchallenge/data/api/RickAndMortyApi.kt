package com.example.emrekizil_usgstajyerchallenge.data.api

import com.example.emrekizil_usgstajyerchallenge.data.dto.locations.LocationResponse
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("location")
    suspend fun getLocations() : LocationResponse
}