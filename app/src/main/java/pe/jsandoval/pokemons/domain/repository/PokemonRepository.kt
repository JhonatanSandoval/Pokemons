package pe.jsandoval.pokemons.domain.repository

import pe.jsandoval.pokemons.domain.model.Pokemon
import pe.jsandoval.pokemons.domain.model.Region

interface PokemonRepository {

    fun getRegions(): List<Region>

    suspend fun getFromLocation(region: Region, onSuccess: (pokemons: List<Pokemon>) -> Unit, onError: (message: String) -> Unit)

}