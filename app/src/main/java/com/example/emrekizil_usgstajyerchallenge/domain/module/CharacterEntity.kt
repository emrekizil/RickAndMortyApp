package com.example.emrekizil_usgstajyerchallenge.domain.module

import com.example.emrekizil_usgstajyerchallenge.data.dto.character.Location
import com.example.emrekizil_usgstajyerchallenge.data.dto.character.Origin
import com.google.gson.annotations.SerializedName

data class CharacterEntity (
    val created: String,
    val episode: String,
    val gender: String,
    val id: Int,
    val image: String,
    val location: String,
    val name: String,
    val origin: String,
    val species: String,
    val status: String,
    )