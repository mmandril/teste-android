package br.com.marcussouza.easyinvest.extensions

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class CurrencyExtensionsTest {

    @Test
    fun `Assert if currency function is correct`() {
        val value = 1000
        assertThat(value.toBigDecimal().toCurrency(), equalTo("R$ 1.000,00"))
    }
}