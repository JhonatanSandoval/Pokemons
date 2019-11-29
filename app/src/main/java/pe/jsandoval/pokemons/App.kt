package pe.jsandoval.pokemons

import android.app.Application
import pe.jsandoval.pokemons.inject.Injector
import pe.jsandoval.pokemons.inject.modules.AppModule
import timber.log.Timber

class App : Application() {

    init {
        Injector.init(AppModule(this))
    }

    override fun onCreate() {
        super.onCreate()

        // initialize dagger
        Injector.get().inject(this)

        if (BuildConfig.DEBUG) {
            enableStrictMode()
            initTimber()
        }
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun enableStrictMode() {
        android.os.StrictMode.setThreadPolicy(
            android.os.StrictMode.ThreadPolicy.Builder()
                //.detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()   // or .detectAll() for all detectable problems
                .penaltyLog()
                .build()
        )

        android.os.StrictMode.setVmPolicy(
            android.os.StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .penaltyLog()
                .penaltyDeath()
                .build()
        )
    }
}