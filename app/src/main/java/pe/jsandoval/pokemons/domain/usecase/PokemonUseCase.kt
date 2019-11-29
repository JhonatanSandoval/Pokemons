package pe.jsandoval.pokemons.domain.usecase

import pe.jsandoval.pokemons.domain.model.Pokemon
import pe.jsandoval.pokemons.domain.model.Region
import pe.jsandoval.pokemons.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonUseCase
@Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend fun getFromLocation(region: Region, onSuccess: (pokemons: List<Pokemon>) -> Unit, onError: (message: String) -> Unit) =
        pokemonRepository.getFromLocation(region, onSuccess, onError)

    fun getRegions(): List<Region> = pokemonRepository.getRegions()

}