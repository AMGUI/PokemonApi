package com.example.pokerapi.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokerapi.R
import com.example.pokerapi.adapter.AdapterPokemon
import com.example.pokerapi.model.PokemonApiResult
import com.example.pokerapi.model.PokemonDetails
import com.example.pokerapi.model.PokemonTypes
import com.example.pokerapi.viewModel.PokemonViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {
   lateinit var adapterPokemon: AdapterPokemon
   private  lateinit  var recicleView : RecyclerView
   private  val pokemon : MutableList<PokemonApiResult> = mutableListOf()
   private  val pokemonViewModel : PokemonViewModel by viewModel()
   private  var isFABOpen: Boolean = false
    lateinit var fab :FloatingActionButton
    lateinit var fab1 :FloatingActionButton
    lateinit var fab2 :FloatingActionButton
    lateinit var fab3 :FloatingActionButton
    lateinit var fab4 :FloatingActionButton


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        fab  = view.findViewById(R.id.fab)
        fab1 = view.findViewById(R.id.fab1)
        fab2 = view.findViewById(R.id.fab2)
        fab3 = view.findViewById(R.id.fab3)
        fab4 = view.findViewById(R.id.fab4)
        closeFABMenu()
        recebendoView(fab)

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

    fun recebendoView(fab: FloatingActionButton){
        fab.setOnClickListener {
            if(!isFABOpen){
                showFABMenu()
            }else{
                closeFABMenu()

            }

        }


    }
    fun showFABMenu(){

        isFABOpen=true
        fab1.animate().translationY(-getResources().getDimension(R.dimen.standard_55))
        fab2.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
        fab3.animate().translationY(-getResources().getDimension(R.dimen.standard_155));
        fab4.animate().translationY(-getResources().getDimension(R.dimen.standard_205));

    }

    fun closeFABMenu(){
        isFABOpen=false;
        fab1.animate().translationY(1000f)
        fab2.animate().translationY(1000f)
        fab3.animate().translationY(1000f)
        fab4.animate().translationY(1000f)
        fab1.isGone
        fab2.isGone
        fab3.isGone
        fab4.isGone
    }



}