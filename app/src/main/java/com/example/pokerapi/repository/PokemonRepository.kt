package com.example.pokerapi.repository

import retrofit2.Call
import com.example.pokerapi.model.PokemonResponse

interface PokemonRepository {
suspend fun requestPokemons(offset : String , limit: String) : PokemonResponse
}