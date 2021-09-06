package com.example.pokerapi.network


import com.example.pokerapi.model.PokemonResponse

import retrofit2.http.GET


interface PokemonApi {
@GET("pokemon.json")
suspend  fun getPokemons(): PokemonResponse

}

