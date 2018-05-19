package com.robertvargic.cryptochecker.ui.portfolio

import android.content.Context
import com.robertvargic.cryptochecker.models.Currency
import com.robertvargic.cryptochecker.networking.RetrofitUtil
import com.robertvargic.cryptochecker.networking.base.TaskListener
import com.robertvargic.cryptochecker.networking.tasks.GetCurrencyTask

class PortfolioPresenter : PortfolioContract.Presenter {

    lateinit var portfolioView: PortfolioContract.View

    constructor(portfolioView: PortfolioContract.View) {
        this.portfolioView = portfolioView
    }

    override fun getCurrencyValueFromEndpoint(context: Context, currencyId: String) {
        val getCurrency = GetCurrencyTask(RetrofitUtil().createRetrofitForUrl(), currencyId)

        getCurrency.execute(object : TaskListener<Currency> {
            override fun onPreExecute() {
            }

            override fun onSuccess(result: Currency) {

            }

            override fun onError(error: Throwable) {
            }

        })
    }

    override fun getUserCurrenciesFromDatabase(context: Context) {
    }

    override fun start() {
    }
}