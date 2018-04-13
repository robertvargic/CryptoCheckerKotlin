package com.robertvargic.cryptochecker.ui.currencyList

import android.content.Context

class CurrencyListPresenter : CurrencyListContract.Presenter {

    private var currencyListView : CurrencyListContract.View

    constructor(currencyListView: CurrencyListContract.View) {
        this.currencyListView = currencyListView
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrencyList(context: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}