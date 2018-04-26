package com.robertvargic.cryptochecker.ui.portfolio

import android.app.Fragment
import android.os.Bundle

class PortfolioFragment : Fragment(), PortfolioContract.View {

    lateinit var portfolioPresenter: PortfolioContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setPresenter(PortfolioPresenter(this))
    }

    override fun startLoadingAnimation() {
    }

    override fun stopLoadingAnimation() {
    }

    override fun loadCurrencyListFromDatabase() {
    }

    override fun loadPortfolioValue() {
    }

    override fun setPresenter(presenter: PortfolioContract.Presenter) {
        portfolioPresenter = presenter
    }

}
