package com.example.emrekizil_usgstajyerchallenge.domain.module

import com.example.emrekizil_usgstajyerchallenge.data.dto.character.Location
import com.example.emrekizil_usgstajyerchallenge.data.dto.character.Origin
import com.google.gson.annotations.SerializedName

data class CharacterEntity (
    @SerializedName("created")
    val created: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String,
    )