package com.robertvargic.cryptochecker.networking.Old

import com.robertvargic.cryptochecker.models.Currency
import com.robertvargic.cryptochecker.networking.ApiService
import retrofit2.*

class GetCurrencyListTask(retrofit: Retrofit) : ServerTask<MutableList<Currency>> {

    private var mService: ApiService = retrofit.create(ApiService::class.java)

    override fun execute(listener: TaskListener<MutableList<Currency>>) {
        listener.onPreExecute()
        val call = mService.getCurrencyList()

        call.enqueue(object : Callback<MutableList<Currency>> {
            override fun onFailure(call: Call<MutableList<Currency>>?, t: Throwable?) {
                t?.run { listener.onError(this) }
            }

            override fun onResponse(call: Call<MutableList<Currency>>?, response: Response<MutableList<Currency>>?) {
                response?.body()?.run { listener.onSuccess(this) }
                response?.errorBody()?.run { listener.onError(HttpException(response)) }
            }
        })
    }
}