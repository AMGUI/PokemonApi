package com.example.pokerapi.network

import com.example.pokerapi.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
    fun getPokemons(
            @Query("offset") offset :String,
            @Query("limit")  limit  :String
    ): PokemonResponse
}