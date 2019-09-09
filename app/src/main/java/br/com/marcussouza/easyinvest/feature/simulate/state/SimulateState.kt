package br.com.marcussouza.easyinvest.feature.simulate.state

import br.com.marcussouza.easyinvest.data.model.SimulateResult

open class SimulateState {

    object ShowLoading : SimulateState()
    object HideLoading : SimulateState()
    object ShowError : SimulateState()
    object ShowNoInternt : SimulateState()

    data class ShowSimulateSucces(val simulateResult: SimulateResult) : SimulateState()
}