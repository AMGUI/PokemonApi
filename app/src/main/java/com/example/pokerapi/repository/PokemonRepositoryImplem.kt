package com.example.pokerapi.repository

import android.util.Log
import com.example.pokerapi.model.PokemonApiResult
import com.example.pokerapi.model.PokemonResponse

import com.example.pokerapi.network.PokemonApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepositoryImplem(private val pokemonApi: PokemonApi):PokemonRepository {
    override suspend fun requestPokemons(): PokemonResponse {
        return try {
            val response = withContext(Dispatchers.IO) {
                pokemonApi.getPokemons()
            }
            response

        } catch (e: Exception) {
            Log.d("Erro", "pokemon deu ruim")
            throw e

        }

    }


}


