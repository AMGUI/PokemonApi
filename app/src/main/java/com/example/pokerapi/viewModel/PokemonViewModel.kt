package com.example.pokerapi.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokerapi.model.PokemonResponse
import com.example.pokerapi.repository.PokemonRepositoryImplem
import kotlinx.coroutines.launch

class PokemonViewModel( private val repositoryImplem: PokemonRepositoryImplem): ViewModel() {
    private val _pokomonReponse: MutableLiveData<PokemonResponse> = MutableLiveData()
     val pokomonlivedata: LiveData<PokemonResponse> get() = _pokomonReponse

    init {getPokemon() }


    fun getPokemon():LiveData<PokemonResponse>{
        viewModelScope.launch {
            val result = repositoryImplem.requestPokemons("0","151")
            _pokomonReponse.postValue(result)
        }
        return pokomonlivedata

    }





}