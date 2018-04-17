package com.robertvargic.cryptochecker.networking

interface ApiService {

    @retrofit2.http.GET("v1/ticker/")
    fun getCurrencyList()


}