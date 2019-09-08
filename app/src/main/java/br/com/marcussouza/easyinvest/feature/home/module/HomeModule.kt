package br.com.marcussouza.easyinvest.feature.home.module

import br.com.marcussouza.easyinvest.feature.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

internal val homeModule = module {
    viewModel { HomeViewModel() }
}

internal val provideHomeModule = loadKoinModules(homeModule)
fun loadHomeModule() = provideHomeModule