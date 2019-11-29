package pe.jsandoval.pokemons.presentation.main

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import pe.jsandoval.pokemons.domain.model.Region
import pe.jsandoval.pokemons.domain.usecase.PokemonUseCase
import pe.jsandoval.pokemons.presentation.base.BasePresenter
import timber.log.Timber
import javax.inject.Inject

class PokemonPresenter
@Inject constructor(
    private val pokemonUseCase: PokemonUseCase
) : BasePresenter<PokemonView>() {

    fun getPokemons(region: Region) {
        view?.showProgress()
        CoroutineScope(IO).launch {
            pokemonUseCase.getFromLocation(region,
                {
                    Timber.d(it.toString())
                    view?.loadPokemons(it)
                }, {
                    Timber.e(it)
                })
        }
    }

    fun getRegions(): List<Region> = pokemonUseCase.getRegions()

}