package com.example.pokerapi.repository


import com.example.pokerapi.model.PokemonResponse

interface PokemonRepository {
suspend fun requestPokemons() : PokemonResponse

}