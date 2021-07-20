package com.example.pokerapi.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokerapi.network.PokemonService
import com.example.pokerapi.repository.PokemonRepositoryImplem

@Suppress("UNCHECKED_CAST")
class FactoreViewModal : ViewModelProvider.NewInstanceFactory() {


    private val retrofitClient by lazy {PokemonService.ProviderApi() }
    private val animeRepository by lazy { PokemonRepositoryImplem(retrofitClient) }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PokemonViewModel(animeRepository) as T
    }

}