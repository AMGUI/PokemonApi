package com.example.pokerapi.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokerapi.model.PokemonApiResult
import com.example.pokerapi.model.PokemonDetails
import com.example.pokerapi.model.PokemonResponse

import com.example.pokerapi.repository.PokemonRepository

import kotlinx.coroutines.launch


class PokemonViewModel( private val repositoryImplem: PokemonRepository): ViewModel() {
    private val _pokomonReponse: MutableLiveData<PokemonResponse> = MutableLiveData()
    val pokomonlivedata: LiveData<PokemonResponse> get() = _pokomonReponse


    init {getPokemon()  }


    fun getPokemon():LiveData<PokemonResponse>{
        viewModelScope.launch {
            val result = repositoryImplem.requestPokemons()
            _pokomonReponse.postValue(result)

        }
        return pokomonlivedata

    }






}