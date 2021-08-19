package com.example.pokerapi.repository

import com.example.pokerapi.model.PokemonDetails
import com.example.pokerapi.model.PokemonResponse

interface PokemonRepository {
suspend fun requestPokemons(offset : String , limit: String) : PokemonResponse
suspend fun requestDetails(nomePokemon:String) : PokemonDetails
}