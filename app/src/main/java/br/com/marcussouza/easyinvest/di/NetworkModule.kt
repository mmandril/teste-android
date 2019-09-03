package br.com.marcussouza.easyinvest.di

import br.com.marcussouza.easyinvest.di.config.provideApi
import org.koin.dsl.module

val netWorkModule = module {
    single { provideApi() }
}