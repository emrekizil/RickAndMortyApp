package com.example.emrekizil_usgstajyerchallenge.utility

fun List<String>.addCharactersIds():String{
    return this.map {
        it.split("/").last()
    }.joinToString(",")
}