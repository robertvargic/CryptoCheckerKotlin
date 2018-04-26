package com.robertvargic.cryptochecker.ui.portfolio

import android.content.Context
import com.robertvargic.cryptochecker.ui.base.BasePresenter
import com.robertvargic.cryptochecker.ui.base.BaseView

object PortfolioContract {

    interface View : BaseView<Presenter> {
        fun startLoadingAnimation()
        fun stopLoadingAnimation()
        fun loadCurrencyListFromDatabase()
        fun loadPortfolioValue()
    }

    interface Presenter : BasePresenter {
        fun getCurrencyValueFromEndpoint(context: Context, currencyId: String)
        fun getUserCurrenciesFromDatabase(context: Context)
    }
}