package br.com.marcussouza.easyinvest.extensions

import java.math.BigDecimal

fun BigDecimal.toPercent(): String {
    return "${this.setScale(2, BigDecimal.ROUND_HALF_EVEN)} %".replace(".", ",")
}