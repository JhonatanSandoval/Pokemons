package pe.jsandoval.pokemons.inject.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pe.jsandoval.pokemons.BuildConfig
import pe.jsandoval.pokemons.data.Api
import pe.jsandoval.pokemons.data.AppInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideAppInterceptor(): AppInterceptor {
        return AppInterceptor(BuildConfig.VERSION_NAME)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(appInterceptor: AppInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(appInterceptor)
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideApi(okHttpClient: OkHttpClient): Api {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://pokeapi.co/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(Api::class.java)
    }

}