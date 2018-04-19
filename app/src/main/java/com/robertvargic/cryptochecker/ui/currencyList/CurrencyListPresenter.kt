package com.robertvargic.cryptochecker.ui.currencyList

import android.content.Context

class CurrencyListPresenter : CurrencyListContract.Presenter {

    private var currencyListView : CurrencyListContract.View

    constructor(currencyListView: CurrencyListContract.View) {
        this.currencyListView = currencyListView
    }

    override fun start() {
    }

    override fun getCurrencyList(context: Context) {
    }
}