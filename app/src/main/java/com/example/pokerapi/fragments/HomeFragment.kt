package com.example.pokerapi.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokerapi.R
import com.example.pokerapi.adapter.AdapterPokemon
import com.example.pokerapi.model.PokemonApiResult
import com.example.pokerapi.model.PokemonDetails
import com.example.pokerapi.model.PokemonTypes
import com.example.pokerapi.viewModel.PokemonViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {
   lateinit var adapterPokemon: AdapterPokemon
   private  lateinit  var recicleView : RecyclerView
   private  val pokemon : MutableList<PokemonApiResult> = mutableListOf()
   private  val pokemonViewModel : PokemonViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
       recicleView = view.findViewById(R.id.recyclerViewPokemon)

        setHasOptionsMenu(true)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterPokemon = AdapterPokemon(pokemon)
        recicleView.apply {
            layoutManager = GridLayoutManager(context, 2) //LinearLayoutManager(context)
            adapter = adapterPokemon
            hasFixedSize()

        }
        pokemonViewModel.pokomonlivedata.observe(viewLifecycleOwner,{pokemon -> updateData(pokemon.results)})
    }


    private fun updateData(data: List<PokemonApiResult>) {
        pokemon.clear()
        pokemon.addAll((data))
        adapterPokemon.notifyDataSetChanged()


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_busca,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.op01 -> {
                Toast.makeText(context, "tudo oks", Toast.LENGTH_SHORT).show()
            }
        }


        return true
    }



}