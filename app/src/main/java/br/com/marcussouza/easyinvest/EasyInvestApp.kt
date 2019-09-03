package br.com.marcussouza.easyinvest

import android.app.Application
import br.com.marcussouza.easyinvest.di.netWorkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EasyInvestApp : Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@EasyInvestApp)
            modules(netWorkModule)
        }
    }
}