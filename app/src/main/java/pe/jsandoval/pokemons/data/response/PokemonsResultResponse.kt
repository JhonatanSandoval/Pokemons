package pe.jsandoval.pokemons.data.response

import pe.jsandoval.pokemons.domain.model.Pokemon

data class PokemonResult(
    val results: List<Pokemon> = arrayListOf()
)