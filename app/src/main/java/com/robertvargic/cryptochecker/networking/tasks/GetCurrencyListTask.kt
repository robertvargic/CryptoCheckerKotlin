package com.robertvargic.cryptochecker.networking.tasks

import com.robertvargic.cryptochecker.models.Currency
import com.robertvargic.cryptochecker.networking.base.BaseTask
import com.robertvargic.cryptochecker.networking.base.ServerTask
import com.robertvargic.cryptochecker.networking.base.TaskListener
import retrofit2.*

class GetCurrencyListTask(retrofit: Retrofit) : BaseTask(retrofit), ServerTask<MutableList<Currency>> {

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