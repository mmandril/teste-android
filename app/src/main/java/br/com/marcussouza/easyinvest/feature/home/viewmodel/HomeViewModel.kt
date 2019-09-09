package br.com.marcussouza.easyinvest.feature.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.marcussouza.easyinvest.feature.base.BaseViewModel
import br.com.marcussouza.easyinvest.feature.home.state.HomeState

class HomeViewModel : BaseViewModel() {

    private val _homeState = MutableLiveData<HomeState>()
    val homeState: LiveData<HomeState>
        get() = _homeState


    fun validateForm(
        investedAmount: String?,
        index: String?,
        rate: String?,
        isTaxFree: Boolean = false,
        maturityDate: String?
    ) {

        if (investedAmount.isNullOrEmpty() || index.isNullOrEmpty() || rate.isNullOrEmpty() || maturityDate.isNullOrEmpty()) {
            _homeState.postValue(HomeState.NotValidForm)
        } else {
            _homeState.postValue(HomeState.ValidForm)
        }
    }
}