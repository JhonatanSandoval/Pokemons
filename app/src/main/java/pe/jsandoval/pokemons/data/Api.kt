package pe.jsandoval.pokemons.data

import pe.jsandoval.pokemons.data.response.PokemonResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("v2/pokemon")
    suspend fun getPokemons(@Query("offset") offset: Int, @Query("limit") limit: Int): Response<PokemonResult>

}