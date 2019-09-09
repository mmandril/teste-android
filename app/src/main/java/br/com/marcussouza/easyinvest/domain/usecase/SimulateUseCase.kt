package br.com.marcussouza.easyinvest.domain.usecase

import br.com.marcussouza.easyinvest.data.model.SimulateResult
import br.com.marcussouza.easyinvest.domain.repository.SimulateRepository
import io.reactivex.Flowable

class SimulateUseCase(private val simulateRepository: SimulateRepository) {

    fun simulate(
        investedAmount: String?,
        index: String?,
        rate: String?,
        isTaxFree: Boolean,
        maturityDate: String?
    ): Flowable<SimulateResult> {
        return simulateRepository.simulate(getMap(investedAmount, index, rate, isTaxFree, maturityDate))
    }

    private fun getMap(
        investedAmount: String?,
        index: String?,
        rate: String?,
        isTaxFree: Boolean,
        maturityDate: String?
    ): Map<String, String?> {
        val data = HashMap<String, String?>()
        data["investedAmount"] = investedAmount
        data["index"] = index
        data["rate"] = rate
        data["isTaxFree"] = isTaxFree.toString()
        data["maturityDate"] = maturityDate
        return data
    }
}