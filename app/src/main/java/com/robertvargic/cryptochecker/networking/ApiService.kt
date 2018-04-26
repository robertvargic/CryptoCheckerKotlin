package com.robertvargic.cryptochecker.networking

import com.robertvargic.cryptochecker.models.Currency
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("v1/ticker/")
    fun getCurrencyList(): Call<MutableList<Currency>>

    @GET("v1/ticker/{id}")
    fun getCurrency(@Path("id") id: String): Call<Currency>

}