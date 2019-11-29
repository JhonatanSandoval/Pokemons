package pe.jsandoval.pokemons.data.repository

import pe.jsandoval.pokemons.data.Api
import pe.jsandoval.pokemons.domain.model.Pokemon
import pe.jsandoval.pokemons.domain.model.Region
import pe.jsandoval.pokemons.domain.repository.PokemonRepository
import timber.log.Timber

class PokemonRepositoryImpl
constructor(
    private val api: Api // or call any other datasource :)
) : PokemonRepository {

    override suspend fun getFromLocation(region: Region, onSuccess: (pokemons: List<Pokemon>) -> Unit, onError: (message: String) -> Unit) {
        try {
            val (_, offset, limit) = region
            val response = api.getPokemons(offset, limit)
            if (response.isSuccessful) {
                response.body()?.let {
                    onSuccess(it.results)
                }
            } else {
                onError("network error")
            }
        } catch (e: Exception) {
            Timber.e(e)
            onError("network error")
        }
    }

    override fun getRegions(): List<Region> { // can also be loaded from local database as room
        val regions = mutableListOf<Region>()
        regions.add(Region("Cualquier región", 0, 3000))
        regions.add(Region("Kanto", 0, 150))
        regions.add(Region("Johto", 151, 250))
        regions.add(Region("Hoeen", 251, 385))
        regions.add(Region("Sinnoh", 386, 492))
        regions.add(Region("Teselia", 493, 648))
        regions.add(Region("Kalos", 649, 720))
        return regions
    }
}