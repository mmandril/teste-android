package br.com.marcussouza.easyinvest.presentation.home.view

import android.os.Bundle
import br.com.marcussouza.easyinvest.presentation.base.BaseActivity
import br.com.marcussouza.easyinvest.presentation.home.module.loadHomeModule
import br.com.marcussouza.easyinvest.presentation.home.viewmodel.HomeViewModel
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