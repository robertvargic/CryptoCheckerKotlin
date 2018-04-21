package com.robertvargic.cryptochecker.networking.Old

import com.robertvargic.cryptochecker.models.Currency
import com.robertvargic.cryptochecker.networking.ApiService
import retrofit2.*

class GetCurrencyListTask(retrofit: Retrofit, serviceClass: Class<ApiService>) : BaseTask<ApiService, MutableList<Currency>>(retrofit, serviceClass), ServerTask<MutableList<Currency>, Void> {
    override fun execute(listener: TaskListener<MutableList<Currency>>, params: Void) {
        listener.onPreExecute()
        val call = mService.getCurrencyList()
        mActiveCall = call

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