package com.example.pokerapi.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokerapi.model.PokemonDetails
import com.example.pokerapi.model.PokemonResponse
import com.example.pokerapi.network.PokemonApi
import com.example.pokerapi.repository.PokemonRepository
import com.example.pokerapi.repository.PokemonRepositoryImplem
import kotlinx.coroutines.launch
import org.koin.core.component.getScopeName

class PokemonViewModel( private val repositoryImplem: PokemonRepository): ViewModel() {
    private val _pokomonReponse: MutableLiveData<PokemonResponse> = MutableLiveData()
    private val _detalspokemon: MutableLiveData<PokemonDetails> = MutableLiveData()
    val pokomonlivedata: LiveData<PokemonResponse> get() = _pokomonReponse
    val pokomonDetaleslivedata: LiveData<PokemonDetails> get() = _detalspokemon

    init {getPokemon() ; getDetailsPokemon() }


    fun getPokemon():LiveData<PokemonResponse>{
        viewModelScope.launch {
            val result = repositoryImplem.requestPokemons("0","151")
            _pokomonReponse.postValue(result)

        }
        return pokomonlivedata

    }
    fun getDetailsPokemon():LiveData<PokemonDetails>{
        viewModelScope.launch {
            val result = repositoryImplem.requestDetails("bulbasaur")
            _detalspokemon.postValue(result)
        }

       return pokomonDetaleslivedata
    }





}