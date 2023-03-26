package com.example.emrekizil_usgstajyerchallenge.data.api


import com.example.emrekizil_usgstajyerchallenge.data.dto.character.CharacterResponse
import com.example.emrekizil_usgstajyerchallenge.data.dto.locations.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("location")
    suspend fun getLocations(@Query("page") pageNumber:Int) : LocationResponse

    @GET("character/{id}")
    suspend fun getCharactersById(@Path("id") id:List<String>) : CharacterResponse
}