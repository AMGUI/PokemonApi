package com.example.pokerapi.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokerapi.R
import com.example.pokerapi.adapter.AdapterPokemon
import com.example.pokerapi.model.PokemonApiResult
import com.example.pokerapi.model.PokemonResponse
import com.example.pokerapi.viewModel.FactoreViewModal
import com.example.pokerapi.viewModel.PokemonViewModel


class HomeFragment : Fragment() {
   lateinit var adapterPokemon: AdapterPokemon
   private lateinit  var recicleView : RecyclerView
    private  val pokemon : MutableList<PokemonApiResult> = mutableListOf()

    private val pokemonViewModel by lazy {
        ViewModelProvider(this, FactoreViewModal()).get(PokemonViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
       recicleView = view.findViewById(R.id.recyclerViewPokemon)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterPokemon = AdapterPokemon(pokemon)
        recicleView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterPokemon
            hasFixedSize()

        }
        pokemonViewModel.pokomonlivedata.observe(viewLifecycleOwner,{pokemon -> updateData(pokemon.results)})
    }


    private fun updateData(data: List<PokemonApiResult>) {
        pokemon.clear()
        pokemon.addAll(data)
        adapterPokemon.notifyDataSetChanged()


    }


}