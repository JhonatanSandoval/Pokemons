package pe.jsandoval.pokemons.presentation.base

abstract class BasePresenter<T : BaseView> : Presenter<T> {

    var view: T? = null

    override fun attach(mvpView: T) {
        view = mvpView
    }

    override fun detach() {
        view = null
    }

}

interface Presenter<T : BaseView> {
    fun attach(mvpView: T)
    fun detach()
}