package pe.jsandoval.pokemons.presentation.main

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import pe.jsandoval.pokemons.R
import pe.jsandoval.pokemons.databinding.ActivityPokemonBinding
import pe.jsandoval.pokemons.domain.model.Pokemon
import pe.jsandoval.pokemons.inject.Injector
import pe.jsandoval.pokemons.presentation.adapter.PokemonAdapter
import pe.jsandoval.pokemons.presentation.base.BaseActivity
import javax.inject.Inject

class PokemonActivity : BaseActivity(), PokemonView {

    @Inject lateinit var presenter: PokemonPresenter
    lateinit var binding: ActivityPokemonBinding

    private val adapter by lazy { PokemonAdapter(this) }

    init {
        Injector.get().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pokemon)
        presenter.attach(this)

        initViews()
        setUpRegions()
    }

    private fun initViews() {
        binding.rvPokemons.layoutManager = GridLayoutManager(this, 3)
        binding.rvPokemons.adapter = adapter
    }

    private fun setUpRegions() {
        val regions = presenter.getRegions()
        binding.spRegions.setItems(regions)
        binding.spRegions.setOnItemSelectedListener { view, position, id, item ->
            val regionSelected = regions[position]
            presenter.getPokemons(regionSelected)
        }
        presenter.getPokemons(regions[3]) // default
    }

    override fun loadPokemons(data: List<Pokemon>) {
        CoroutineScope(Main).launch {
            data.apply pokemonData@{
                adapter.pokemonData = this@pokemonData
                binding.emptyIndicator.isVisible = this@pokemonData.isEmpty()
                binding.rvPokemons.isVisible = this@pokemonData.isNotEmpty()
                if (this@pokemonData.isNotEmpty()) {
                    binding.rvPokemons.scrollToPosition(0)
                }
            }
            hideProgress()
        }
    }

    override fun showProgress() {
        binding.progress.isVisible = true
        binding.rvPokemons.isVisible = false
        binding.emptyIndicator.isVisible = false
    }

    override fun hideProgress() {
        binding.progress.isVisible = false
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

}
