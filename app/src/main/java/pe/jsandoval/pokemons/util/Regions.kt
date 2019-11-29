package pe.jsandoval.pokemons.util

enum class Regions(name: String, offset: Int, limit: Int) {
    KANTO("Kanto", 0, 150),
    JOHTO("Johto", 151, 250),
    HOENN("Hoeen", 251, 385),
    SINNOH("Sinnoh", 386, 492)
}