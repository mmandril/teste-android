package br.com.marcussouza.easyinvest.feature.home.module

import br.com.marcussouza.easyinvest.data.api.Api
import br.com.marcussouza.easyinvest.feature.home.viewmodel.HomeViewModel
import junit.framework.Assert.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import org.mockito.Mockito

class HomeModuleTest : AutoCloseKoinTest() {

    @Before
    fun `Setup all tests`() {
        val netWorkModule = module {
            single { Mockito.mock(Api::class.java) }
        }
        startKoin { modules(arrayListOf(netWorkModule, homeModule)) }
    }

    @Test
    fun `Assert if view model is provided by module`() {
        val homeViewModel by inject<HomeViewModel>()
        with(homeViewModel){
            assertNotNull(this)
            assertEquals(HomeViewModel::class.java, javaClass)
        }
    }
}