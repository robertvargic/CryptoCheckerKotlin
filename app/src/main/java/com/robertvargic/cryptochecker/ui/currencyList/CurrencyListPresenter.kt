package com.robertvargic.cryptochecker.ui.currencyList

import android.content.Context
import com.robertvargic.cryptochecker.models.Currency
import com.robertvargic.cryptochecker.networking.ApiService
import com.robertvargic.cryptochecker.networking.Old.GetCurrencyListTask
import com.robertvargic.cryptochecker.networking.Old.RetrofitUtil
import com.robertvargic.cryptochecker.networking.Old.TaskListener

class CurrencyListPresenter : CurrencyListContract.Presenter {

    private var currencyListView: CurrencyListContract.View

    constructor(currencyListView: CurrencyListContract.View) {
        this.currencyListView = currencyListView
    }

    override fun start() {
    }

    override fun getCurrencyList(context: Context) {

        val getCurrencyListTask: GetCurrencyListTask = GetCurrencyListTask(RetrofitUtil().createRetrofitForUrl(context), ApiService::class.java)

        getCurrencyListTask.execute(object : TaskListener<MutableList<Currency>> {
            override fun onPreExecute() {
            }

            override fun onSuccess(result: MutableList<Currency>?) {
                currencyListView.initListView(result)
            }

            override fun onError(error: Throwable) {
            }

        })
    }
}

private fun GetCurrencyListTask.execute(listener: TaskListener<MutableList<Currency>>) {
}

