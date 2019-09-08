package br.com.marcussouza.easyinvest.data.repository

import br.com.marcussouza.easyinvest.data.api.Api
import br.com.marcussouza.easyinvest.data.model.SimulateResult
import br.com.marcussouza.easyinvest.domain.repository.SimulateRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SimulateRepositoryImpl(private val api: Api) : SimulateRepository {

    override fun simulate(map: Map<String, String>): Flowable<SimulateResult> {
        return api
            .simulate(map)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
    }
}