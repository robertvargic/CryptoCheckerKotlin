package com.robertvargic.cryptochecker.models

import java.util.*

data class Currency(val id: String, val name: String, val symbol: String, val priceUsd: String, val priceBtc: String, val lastUpdated: Date) {
}