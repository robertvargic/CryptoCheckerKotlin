package com.robertvargic.cryptochecker.ui.currencyList

import android.content.Context
import com.robertvargic.cryptochecker.models.Currency
import com.robertvargic.cryptochecker.networking.tasks.GetCurrencyListTask
import com.robertvargic.cryptochecker.networking.RetrofitUtil
import com.robertvargic.cryptochecker.networking.base.TaskListener

class CurrencyListPresenter : CurrencyListContract.Presenter {

    private var currencyListView: CurrencyListContract.View

    constructor(currencyListView: CurrencyListContract.View) {
        this.currencyListView = currencyListView
    }

    override fun start() {
    }

    override fun getCurrencyList(context: Context) {

        val getCurrencyListTask = GetCurrencyListTask(RetrofitUtil().createRetrofitForUrl(context))

        getCurrencyListTask.execute(object : TaskListener<MutableList<Currency>> {
            override fun onSuccess(result: MutableList<Currency>) {
                currencyListView.initListView(result)
            }

            override fun onPreExecute() {
            }

            override fun onError(error: Throwable) {
            }

        })
    }
}


