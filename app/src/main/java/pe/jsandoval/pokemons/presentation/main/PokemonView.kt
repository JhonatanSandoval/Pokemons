package pe.jsandoval.pokemons.presentation.main

import pe.jsandoval.pokemons.domain.model.Pokemon
import pe.jsandoval.pokemons.presentation.base.BaseView

interface PokemonView : BaseView {

    fun loadPokemons(data: List<Pokemon>)

}