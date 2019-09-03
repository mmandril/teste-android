package br.com.marcussouza.easyinvest.presentation.home.module

import br.com.marcussouza.easyinvest.data.repository.SimulateRepositoryImpl
import br.com.marcussouza.easyinvest.domain.repository.SimulateRepository
import br.com.marcussouza.easyinvest.domain.usecase.SimulateUseCase
import br.com.marcussouza.easyinvest.presentation.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

internal val homeModule = module {
    factory<SimulateRepository> { SimulateRepositoryImpl() }
    factory { SimulateUseCase(get()) }
    viewModel { HomeViewModel(get()) }
}

internal val provideHomeModule = loadKoinModules(homeModule)
fun loadHomeModule() = provideHomeModule