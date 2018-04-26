package com.robertvargic.cryptochecker.networking.tasks

import com.robertvargic.cryptochecker.models.Currency
import com.robertvargic.cryptochecker.networking.base.BaseTask
import com.robertvargic.cryptochecker.networking.base.ServerTask
import com.robertvargic.cryptochecker.networking.base.TaskListener
import retrofit2.*

class GetCurrencyTask(retrofit: Retrofit, private val currencyId: String) : BaseTask(retrofit), ServerTask<Currency> {

    override fun execute(listener: TaskListener<Currency>) {
        listener.onPreExecute()
        val call = mService.getCurrency(currencyId)
        call.enqueue(object : Callback<Currency> {
            override fun onFailure(call: Call<Currency>?, t: Throwable?) {
                t?.run { listener.onError(this) }
            }

            override fun onResponse(call: Call<Currency>?, response: Response<Currency>?) {
                response?.body()?.run { listener.onSuccess(this) }
                response?.errorBody()?.run { listener.onError(HttpException(response)) }
            }
        })
    }
}