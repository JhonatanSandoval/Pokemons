package pe.jsandoval.pokemons.presentation.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.jsandoval.pokemons.domain.model.Pokemon
import pe.jsandoval.pokemons.presentation.widget.PokemonView

class PokemonAdapter constructor(private val context: Context) : RecyclerView.Adapter<PokemonAdapter.PokemonHolder>() {

    var pokemonData = listOf<Pokemon>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder = PokemonHolder(PokemonView(context))

    override fun getItemCount(): Int = pokemonData.size

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        val pokemon = getItem(position)
        holder.getPokemonView().setPokemonName(pokemon.name)
        val imgUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemon.getNumber()}.png"
        holder.getPokemonView().loadImage(imgUrl)
    }

    private fun getItem(position: Int): Pokemon = pokemonData[position]

    class PokemonHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun getPokemonView(): PokemonView = itemView as PokemonView
    }

}