package br.com.marcussouza.easyinvest.domain.repository

import br.com.marcussouza.easyinvest.data.model.SimulateResult
import io.reactivex.Flowable

interface SimulateRepository {

    fun simulate(map: Map<String, String>): Flowable<SimulateResult>
}