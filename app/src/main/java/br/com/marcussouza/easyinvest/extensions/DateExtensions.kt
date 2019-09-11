package br.com.marcussouza.easyinvest.extensions

import java.text.SimpleDateFormat
import java.util.*

private var returnFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
private var defaultFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

fun String.toDefaultDate() : String {
    val date = returnFormat.parse(this)
    return date?.let {
        defaultFormat.format(date)
    } ?: run {
        ""
    }
}