package com.example.pokerapi.repository

import android.util.Log
import com.example.pokerapi.model.PokemonDetails
import com.example.pokerapi.model.PokemonResponse
import com.example.pokerapi.network.PokemonApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepositoryImplem(private val pokemonApi: PokemonApi):PokemonRepository {
    override suspend fun requestPokemons(offset: String, limit: String): PokemonResponse {
        return try {
            val response = withContext(Dispatchers.IO) {
                pokemonApi.getPokemons(offset, limit)
            }
            response

        } catch (e: Exception) {
            Log.d("Erro", "pokemon deu ruim")
            throw e

        }

    }

    override suspend fun requestDetails(namePokemon: String): PokemonDetails {
       return try {
           val responseDatails = withContext(Dispatchers.IO) {
               pokemonApi.fetchPokemonInfo(namePokemon)
           }
           responseDatails
       }
       catch (e: Exception){
           Log.d("Erro", "detalhes deu ruim")
           throw e

       }
    }
}


