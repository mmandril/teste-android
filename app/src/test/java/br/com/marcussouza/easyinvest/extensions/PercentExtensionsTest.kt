package br.com.marcussouza.easyinvest.extensions

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class PercentExtensionsTest {

    @Test
    fun `Assert if percent format is correct`() {
        val percent = 0.53
        assertThat(percent.toBigDecimal().toPercent(), equalTo("0,53 %"))
    }
}