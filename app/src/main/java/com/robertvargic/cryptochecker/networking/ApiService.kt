package com.robertvargic.cryptochecker.networking

import com.robertvargic.cryptochecker.models.Currency
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("v1/ticker/")
    fun getCurrencyList(): Call<MutableList<Currency>>

}