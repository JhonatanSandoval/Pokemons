package pe.jsandoval.pokemons.inject.component

import android.app.Application
import dagger.Component
import pe.jsandoval.pokemons.App
import pe.jsandoval.pokemons.data.Api
import pe.jsandoval.pokemons.inject.modules.AppModule
import pe.jsandoval.pokemons.inject.modules.NetworkModule
import pe.jsandoval.pokemons.inject.modules.RepositoryModule
import pe.jsandoval.pokemons.presentation.main.PokemonActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class])
interface AppComponent {

    fun inject(app: App)
    fun inject(pokemonActivity: PokemonActivity)

    val application: Application
    val api: Api
}