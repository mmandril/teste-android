package br.com.marcussouza.easyinvest.feature.simulate.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import br.com.marcussouza.easyinvest.R
import br.com.marcussouza.easyinvest.data.model.SimulateResult
import br.com.marcussouza.easyinvest.extensions.toCurrency
import br.com.marcussouza.easyinvest.extensions.toDefaultDate
import br.com.marcussouza.easyinvest.extensions.toPercent
import br.com.marcussouza.easyinvest.feature.base.BaseActivity
import br.com.marcussouza.easyinvest.feature.simulate.module.loadSimulateModule
import br.com.marcussouza.easyinvest.feature.simulate.state.SimulateState
import br.com.marcussouza.easyinvest.feature.simulate.viewmodel.SimulateViewModel
import kotlinx.android.synthetic.main.activity_simulate.*
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
        simulateActivityProgress.visibility = View.VISIBLE
        simulateScrollView.visibility = View.GONE
    }

    private fun hideLoading() {
        simulateActivityProgress.visibility = View.GONE
    }

    private fun showError() {

    }

    private fun showNoInternet() {

    }

    private fun showSimulateSuccess(simulateResult: SimulateResult) {
        simulateScrollView.visibility = View.VISIBLE
        simulateActivityResult.text = simulateResult.grossAmount.toBigDecimal().toCurrency()
        simulateActivityYieldDescription.text =
            getString(R.string.simulate_result_subtitle, simulateResult.grossAmountProfit.toBigDecimal().toCurrency())
        simulateActivityApplied.text = simulateResult.investmentParameter.investedAmount.toBigDecimal().toCurrency()
        simulateActivityGrossValue.text = simulateResult.grossAmount.toBigDecimal().toCurrency()
        simulateActivityYieldValue.text = simulateResult.grossAmountProfit.toBigDecimal().toCurrency()
        simulateActivityYieldIrValue.text = getString(
            R.string.ir_invested_value,
            simulateResult.taxesAmount.toBigDecimal().toCurrency(),
            simulateResult.taxesRate.toBigDecimal().toPercent()
        )
        simulateActivityNetValue.text = simulateResult.netAmount.toBigDecimal().toCurrency()
        simulateActivityRedemptionDateValue.text = simulateResult.investmentParameter.maturityDate.toDefaultDate()
        simulateActivityTotalDay.text = simulateResult.investmentParameter.maturityTotalDays.toString()
        simulateActivityMonthlyIncome.text = simulateResult.monthlyGrossRateProfit.toBigDecimal().toPercent()
        simulateActivityCdi.text = simulateResult.investmentParameter.rate.toBigDecimal().toPercent()
        simulateActivityAnnual.text = simulateResult.annualNetRateProfit.toBigDecimal().toPercent()
        simulateActivityPeriod.text = simulateResult.rateProfit.toBigDecimal().toPercent()
    }

    companion object {
        const val INVESTEDAMOUT = "investedAmount"
        const val INDEX = "index"
        const val RATE = "rate"
        const val ISTAXFREE = "isTaxFree"
        const val MATURITYDATE = "maturityDate"
    }
}