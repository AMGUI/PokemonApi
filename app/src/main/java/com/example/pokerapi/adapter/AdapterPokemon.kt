package com.example.pokerapi.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView
import com.example.pokerapi.R
import com.example.pokerapi.model.PokemonApiResult
import com.example.pokerapi.model.PokemonDetails


class AdapterPokemon(private val pokemons: List<PokemonApiResult>):RecyclerView.Adapter<AdapterPokemon.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokomons_recicler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pokemons[position])
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

        private val nomePokemon: TextView =itemView.findViewById(R.id.nomePokemon)
        private val imagemPokemon: ImageView =itemView.findViewById(R.id.imageViewPokemon)
        private val frameTipo1: FrameLayout = itemView.findViewById(R.id.frameTipo1)
        private val frameTipo2: FrameLayout = itemView.findViewById(R.id.frameTipo2)
        private val frameTipo3: FrameLayout = itemView.findViewById(R.id.frameTipo3)
        fun bind(entPokemon:PokemonApiResult){
            frameTipo2.isGone = true
            frameTipo3.isGone = true

            nomePokemon.text = entPokemon.name
            imagemPokemon.setImageResource(entPokemon.getThumbnail(itemView.context))
            


        }

    }
}