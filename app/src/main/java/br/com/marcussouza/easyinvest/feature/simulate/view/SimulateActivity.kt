package br.com.marcussouza.easyinvest.feature.simulate.view

import android.os.Bundle
import androidx.lifecycle.Observer
import br.com.marcussouza.easyinvest.R
import br.com.marcussouza.easyinvest.data.model.SimulateResult
import br.com.marcussouza.easyinvest.feature.base.BaseActivity
import br.com.marcussouza.easyinvest.feature.simulate.module.loadSimulateModule
import br.com.marcussouza.easyinvest.feature.simulate.state.SimulateState
import br.com.marcussouza.easyinvest.feature.simulate.viewmodel.SimulateViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SimulateActivity : BaseActivity() {

    private val simulateViewModel: SimulateViewModel by viewModel()
    private var investedAmount: String? = null
    private var index: String? = null
    private var rate: String? = null
    private var isTaxFree: Boolean = false
    private var maturityDate: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulate)
        init()
    }

    private fun init() {
        loadSimulateModule()
        investedAmount = intent.getStringExtra(INVESTEDAMOUT)
        index = intent.getStringExtra(INDEX)
        rate = intent.getStringExtra(RATE)
        isTaxFree = intent.getBooleanExtra(ISTAXFREE, false)
        maturityDate = intent.getStringExtra(MATURITYDATE)

        initObservers()
        simulateViewModel.simulate(investedAmount, index, rate, isTaxFree, maturityDate)
    }

    private fun initObservers() {
        simulateViewModel.simulateState.observe(this, Observer { state ->
            when (state) {
                is SimulateState.ShowLoading -> showLoading()
                is SimulateState.HideLoading -> hideLoading()
                is SimulateState.ShowError -> showError()
                is SimulateState.ShowNoInternt -> showNoInternet()
                is SimulateState.ShowSimulateSucces -> showSimulateSuccess(state.simulateResult)
            }

        })
    }

    private fun showLoading() {

    }

    private fun hideLoading() {

    }

    private fun showError() {

    }

    private fun showNoInternet() {

    }

    private fun showSimulateSuccess(simulateResult: SimulateResult) {

    }

    companion object {
        const val INVESTEDAMOUT = "investedAmount"
        const val INDEX = "index"
        const val RATE = "rate"
        const val ISTAXFREE = "isTaxFree"
        const val MATURITYDATE = "maturityDate"
    }
}