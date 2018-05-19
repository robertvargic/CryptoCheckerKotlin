package com.robertvargic.cryptochecker.ui.currencyList

import com.robertvargic.cryptochecker.models.Currency
import com.robertvargic.cryptochecker.ui.base.BasePresenter
import com.robertvargic.cryptochecker.ui.base.BaseView

object CurrencyListContract {

    interface View : BaseView<Presenter> {
        fun startLoadingAnimation()
        fun stopLoadingAnimation()
        fun initListView(currencyList: MutableList<Currency>?)
    }

    interface Presenter : BasePresenter {
        fun getCurrencyList()
    }
}