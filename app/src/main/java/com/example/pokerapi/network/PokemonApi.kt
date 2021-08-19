package com.example.pokerapi.network

import com.example.pokerapi.model.PokemonDetails
import com.example.pokerapi.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
  suspend  fun getPokemons(
            @Query("offset") offset :String,
            @Query("limit")  limit  :String
    ): PokemonResponse

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(@Path("name") name: String):PokemonDetails

}