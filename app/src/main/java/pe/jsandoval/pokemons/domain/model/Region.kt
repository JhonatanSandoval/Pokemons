package pe.jsandoval.pokemons.domain.model

data class Region(
    val name: String,
    val offset: Int,
    val limit: Int
) {
    override fun toString(): String = name
}