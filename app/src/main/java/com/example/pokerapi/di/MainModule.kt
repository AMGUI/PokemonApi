 package com.example.pokerapi.di



import com.example.pokerapi.network.PokemonApi
import com.example.pokerapi.repository.PokemonRepository
import com.example.pokerapi.repository.PokemonRepositoryImplem
import com.example.pokerapi.viewModel.PokemonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val mainModule = module{

    single { Retrofit.Builder()
        //.baseUrl("https://pokeapi.co/api/v2/")
        .baseUrl("https://amgui.github.io/pokemon-data/")
        .addConverterFactory(GsonConverterFactory.create())
        .build() }

    single  {
        get<Retrofit>().create(PokemonApi::class.java)
   }
    factory<PokemonRepository> {
        PokemonRepositoryImplem(pokemonApi = get())
    }

    viewModel {
        PokemonViewModel(
           repositoryImplem = get()
        )

    }
}