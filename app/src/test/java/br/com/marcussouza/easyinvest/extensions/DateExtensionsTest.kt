package br.com.marcussouza.easyinvest.extensions

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class DateExtensionsTest {

    @Test
    fun `Assert if date format is correct`() {
        val date = "2023-03-03T00:00:00"
        assertThat(date.toDefaultDate(), equalTo("03/03/2023"))
    }
}