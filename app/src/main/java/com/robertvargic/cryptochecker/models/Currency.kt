package com.robertvargic.cryptochecker.models

import com.google.gson.annotations.SerializedName
import java.util.*

typealias Json = SerializedName

data class Currency(val id: String,
                    val name: String,
                    val symbol: String,
                    @Json("price_usd") val priceUsd: String,
                    @Json("price_btc")val priceBtc: String,
                    @Json("last_updated")val lastUpdated: Date) {
}