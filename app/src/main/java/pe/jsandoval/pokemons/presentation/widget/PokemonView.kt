package pe.jsandoval.pokemons.presentation.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import coil.api.load
import pe.jsandoval.pokemons.R

class PokemonView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null) : LinearLayout(context, attributeSet) {

    var ivImage: ImageView? = null
    var tvPokemon: TextView? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.pokemon_view, this, true)

        ivImage = findViewById(R.id.ivImage)
        tvPokemon = findViewById(R.id.tvPokemon)
    }

    fun loadImage(url: String) {
        ivImage?.load(url) { crossfade(true) }
    }

    fun setPokemonName(name: String) {
        tvPokemon?.text = name
    }

}