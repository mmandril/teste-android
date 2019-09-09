package br.com.marcussouza.easyinvest.data.api

import br.com.marcussouza.easyinvest.data.model.SimulateResult
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface Api {

    @GET("/calculator/simulate")
    fun simulate(@QueryMap arguments: Map<String, String?>): Flowable<SimulateResult>
}