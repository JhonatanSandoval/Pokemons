package pe.jsandoval.pokemons.inject.modules

import dagger.Module
import dagger.Provides
import pe.jsandoval.pokemons.data.Api
import pe.jsandoval.pokemons.data.repository.PokemonRepositoryImpl
import pe.jsandoval.pokemons.domain.repository.PokemonRepository

@Module
class RepositoryModule {

    @Provides
    fun providePokemonRepository(api: Api): PokemonRepository = PokemonRepositoryImpl(api)

}