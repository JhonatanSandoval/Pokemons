package pe.jsandoval.pokemons.data

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AppInterceptor(private val versionName: String) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder
            .addHeader("Accept", "application/json")
            .addHeader("client-app-version", versionName)
        return chain.proceed(builder.build())
    }
}
