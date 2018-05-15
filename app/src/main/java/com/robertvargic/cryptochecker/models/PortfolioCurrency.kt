package com.robertvargic.cryptochecker.models

import io.realm.RealmObject
import java.util.*

data class PortfolioCurrency(val id: String,
                             val name: String,
                             val symbol: String,
                             @Json("currency_amount") val amountCurrency: Float,
                             @Json("last_updated") val lastUpdated: Date) : RealmObject() {
}