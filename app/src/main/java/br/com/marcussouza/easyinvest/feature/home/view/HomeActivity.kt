package br.com.marcussouza.easyinvest.feature.home.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import br.com.marcussouza.easyinvest.R
import br.com.marcussouza.easyinvest.feature.base.BaseActivity
import br.com.marcussouza.easyinvest.feature.home.module.loadHomeModule
import br.com.marcussouza.easyinvest.feature.home.state.HomeState
import br.com.marcussouza.easyinvest.feature.home.viewmodel.HomeViewModel
import br.com.marcussouza.easyinvest.feature.simulate.view.SimulateActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity(), TextWatcher {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()
    }

    private fun init() {
        loadHomeModule()
        initListeners()
        initObservers()
    }

    private fun initListeners() {
        activityHomeSimulateBtn.setOnClickListener {
            simulate()
        }

        activityHomeValue.addTextChangedListener(this)
        activityHomeDate.addTextChangedListener(this)
        activityHomeCdi.addTextChangedListener(this)
    }

    private fun initObservers() {
        homeViewModel.homeState.observe(this, Observer { state ->
            when (state) {
                is HomeState.ValidForm -> toggleBtn(true)
                is HomeState.NotValidForm -> toggleBtn(false)
            }
        })
    }

    private fun toggleBtn(isValid: Boolean) {
        activityHomeSimulateBtn.isEnabled = isValid
    }

    private fun simulate() {
        val intent = Intent(this, SimulateActivity::class.java)
        intent.putExtra(SimulateActivity.INVESTEDAMOUT, activityHomeValue.text.toString())
        intent.putExtra(SimulateActivity.INDEX, "CDI")
        intent.putExtra(SimulateActivity.RATE, activityHomeCdi.text.toString())
        intent.putExtra(SimulateActivity.ISTAXFREE, false)
        intent.putExtra(SimulateActivity.MATURITYDATE, activityHomeDate.text.toString())
        startActivity(intent)
    }

    override fun afterTextChanged(p0: Editable?) {
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        homeViewModel.validateForm(
            activityHomeValue.text.toString(),
            "CDI",
            activityHomeCdi.text.toString(),
            false,
            activityHomeDate.text.toString()
        )
    }
}