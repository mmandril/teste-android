package br.com.marcussouza.easyinvest.feature.simulate.module

import br.com.marcussouza.easyinvest.data.api.Api
import br.com.marcussouza.easyinvest.data.repository.SimulateRepositoryImpl
import br.com.marcussouza.easyinvest.domain.repository.SimulateRepository
import br.com.marcussouza.easyinvest.domain.usecase.SimulateUseCase
import br.com.marcussouza.easyinvest.feature.simulate.viewmodel.SimulateViewModel
import junit.framework.Assert.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import org.mockito.Mockito

class SimulateModuleTest : AutoCloseKoinTest() {

    @Before
    fun `Setup all tests`() {
        val netWorkModule = module {
            single { Mockito.mock(Api::class.java) }
        }
        startKoin { modules(arrayListOf(netWorkModule, simulateModule)) }
    }

    @Test
    fun `Assert if repository is provided by module`() {
        val simulateRepository by inject<SimulateRepository>()
        with(simulateRepository) {
            assertNotNull(this)
            assertEquals(SimulateRepositoryImpl::class.java, javaClass)
        }
    }

    @Test
    fun `Assert if use case is provided by module`() {
        val simulateUseCase by inject<SimulateUseCase>()
        with(simulateUseCase) {
            assertNotNull(this)
            assertEquals(SimulateUseCase::class.java, javaClass)
        }
    }

    @Test
    fun `Assert if view model is provided by module`() {
        val simulateViewModel by inject<SimulateViewModel>()
        with(simulateViewModel) {
            assertNotNull(this)
            assertEquals(SimulateViewModel::class.java, javaClass)
        }
    }
}