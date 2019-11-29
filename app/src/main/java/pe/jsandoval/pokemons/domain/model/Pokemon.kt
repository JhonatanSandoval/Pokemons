package pe.jsandoval.pokemons.domain.model

data class Pokemon(
    val name: String,
    val url: String
) {
    fun getNumber(): Int {
        val urlSplitter = url.split("/")
        return Integer.parseInt(urlSplitter[urlSplitter.size - 2])
    }
}