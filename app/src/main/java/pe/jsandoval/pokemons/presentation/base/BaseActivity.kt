package pe.jsandoval.pokemons.presentation.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseView {
    override fun showProgress() {
        // override if needed
    }

    override fun hideProgress() {
        // override if needed
    }
}