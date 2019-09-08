package br.com.marcussouza.easyinvest.domain.usecase

import br.com.marcussouza.easyinvest.data.model.SimulateResult
import br.com.marcussouza.easyinvest.domain.repository.SimulateRepository
import io.reactivex.Flowable
import java.util.*
import kotlin.collections.HashMap

class SimulateUseCase(private val simulateRepository: SimulateRepository) {

    fun simulate(
        investedAmount: Float,
        index: String,
        rate: Int,
        isTaxFree: Boolean,
        maturityDate: Date
    ): Flowable<SimulateResult> {
        return simulateRepository.simulate(getMap(investedAmount, index, rate, isTaxFree, maturityDate))
    }

    private fun getMap(
        investedAmount: Float,
        index: String,
        rate: Int,
        isTaxFree: Boolean,
        maturityDate: Date
    ): Map<String, String> {
        val data = HashMap<String, String>()
        data["investedAmount"] = investedAmount.toString()
        data["index"] = index
        data["rate"] = rate.toString()
        data["isTaxFree"] = isTaxFree.toString()
        data["maturityDate"] = maturityDate.toString()
        return data
    }
}