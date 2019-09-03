package br.com.marcussouza.easyinvest.feature.home.view

import android.os.Bundle
import br.com.marcussouza.easyinvest.feature.base.BaseActivity
import br.com.marcussouza.easyinvest.feature.home.module.loadHomeModule
import br.com.marcussouza.easyinvest.feature.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {
        loadHomeModule()
    }
}