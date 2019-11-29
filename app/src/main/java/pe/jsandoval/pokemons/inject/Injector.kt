package pe.jsandoval.pokemons.inject

import pe.jsandoval.pokemons.inject.component.AppComponent
import pe.jsandoval.pokemons.inject.component.DaggerAppComponent
import pe.jsandoval.pokemons.inject.modules.AppModule

object Injector {

    private lateinit var appComponent: AppComponent

    @JvmStatic
    @Synchronized
    fun init(appModule: AppModule) {
        appComponent = DaggerAppComponent.builder()
            .appModule(appModule)
            .build()
    }

    @JvmStatic
    @Synchronized
    fun get(): AppComponent {
        return appComponent
    }

}