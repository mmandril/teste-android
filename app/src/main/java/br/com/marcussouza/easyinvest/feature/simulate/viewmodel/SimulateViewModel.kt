package br.com.marcussouza.easyinvest.feature.simulate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.marcussouza.easyinvest.domain.usecase.SimulateUseCase
import br.com.marcussouza.easyinvest.feature.base.BaseViewModel
import br.com.marcussouza.easyinvest.feature.simulate.state.SimulateState
import java.io.IOException

class SimulateViewModel(private val simulateUseCase: SimulateUseCase) : BaseViewModel() {

    private val _simulateState = MutableLiveData<SimulateState>()

    val simulateState: LiveData<SimulateState>
        get() = _simulateState

    fun simulate(
        investedAmount: String?,
        index: String?,
        rate: String?,
        isTaxFree: Boolean,
        maturityDate: String?
    ) {
        _simulateState.postValue(SimulateState.ShowLoading)
        disposables.add(
            simulateUseCase
                .simulate(
                    investedAmount,
                    index,
                    rate,
                    isTaxFree,
                    maturityDate
                )
                .subscribe({
                    _simulateState.postValue(SimulateState.HideLoading)
                    _simulateState.postValue(SimulateState.ShowSimulateSucces(it))
                }, {
                    _simulateState.postValue(SimulateState.HideLoading)
                    validateError(it)
                })
        )
    }

    private fun validateError(throwable: Throwable) {
        if (throwable is IOException) {
            _simulateState.postValue(SimulateState.ShowNoInternt)
        } else {
            _simulateState.postValue(SimulateState.ShowError)
        }
    }
}