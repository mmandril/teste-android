package br.com.marcussouza.easyinvest.feature.base

open class BaseState {
    object ShowLoadind : BaseState()
    object HideLoading : BaseState()
    object ShowError : BaseState()
    object ShowNoInternet : BaseState()
}