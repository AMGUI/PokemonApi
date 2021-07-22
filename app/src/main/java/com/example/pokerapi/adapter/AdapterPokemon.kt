package com.example.pokerapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokerapi.R
import com.example.pokerapi.model.PokemonApiResult


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

        fun bind(entPokemon:PokemonApiResult){
            nomePokemon.text = entPokemon.name
            Glide.with(itemView.context).load(entPokemon.img).into(imagemPokemon)
        }

    }
}