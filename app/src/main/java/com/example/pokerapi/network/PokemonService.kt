package com.example.pokerapi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://pokeapi.co/api/v2/"
private  val retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
object PokemonService {
    fun ProviderApi() : PokemonApi{
        return retrofit.create(PokemonApi::class.java)
    }
}