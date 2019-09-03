package br.com.marcussouza.easyinvest.data.model

import com.squareup.moshi.Json

data class SimulateResult(
    @Json(name = "annualGrossRateProfit") val annualGrossRateProfit: Double,
    @Json(name = "annualNetRateProfit") val annualNetRateProfit: Double,
    @Json(name = "dailyGrossRateProfit") val dailyGrossRateProfit: Double,
    @Json(name = "grossAmount") val grossAmount: Double,
    @Json(name = "grossAmountProfit") val grossAmountProfit: Double,
    @Json(name = "investmentParameter") val investmentParameter: InvestmentParameter,
    @Json(name = "monthlyGrossRateProfit") val monthlyGrossRateProfit: Double,
    @Json(name = "netAmount") val netAmount: Double,
    @Json(name = "netAmountProfit") val netAmountProfit: Double,
    @Json(name = "rateProfit") val rateProfit: Double,
    @Json(name = "taxesAmount") val taxesAmount: Double,
    @Json(name = "taxesRate") val taxesRate: Double
)

data class InvestmentParameter(
    @Json(name = "investedAmount") val investedAmount: Double,
    @Json(name = "isTaxFree") val isTaxFree: Boolean,
    @Json(name = "maturityBusinessDays") val maturityBusinessDays: Int,
    @Json(name = "maturityDate") val maturityDate: String,
    @Json(name = "maturityTotalDays") val maturityTotalDays: Int,
    @Json(name = "rate") val rate: Double,
    @Json(name = "yearlyInterestRate") val yearlyInterestRate: Double
)