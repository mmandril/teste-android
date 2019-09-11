package br.com.marcussouza.easyinvest.extensions

import java.text.NumberFormat
import java.util.*

fun java.math.BigDecimal.toCurrency(): String{
    return NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(this)
}