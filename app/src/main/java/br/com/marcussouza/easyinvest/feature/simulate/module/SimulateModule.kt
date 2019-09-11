package br.com.marcussouza.easyinvest.feature.simulate.module

import br.com.marcussouza.easyinvest.data.repository.SimulateRepositoryImpl
import br.com.marcussouza.easyinvest.domain.repository.SimulateRepository
import br.com.marcussouza.easyinvest.domain.usecase.SimulateUseCase
import br.com.marcussouza.easyinvest.feature.simulate.viewmodel.SimulateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

internal val simulateModule = module {
    factory<SimulateRepository> { SimulateRepositoryImpl(get()) }
    factory { SimulateUseCase(get()) }
    viewModel { SimulateViewModel(get()) }
}

internal val provideSimulateModule by lazy { loadKoinModules(simulateModule) }
fun loadSimulateModule() = provideSimulateModule