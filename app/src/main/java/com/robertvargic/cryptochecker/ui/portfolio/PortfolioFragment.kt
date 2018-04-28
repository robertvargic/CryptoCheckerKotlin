package com.robertvargic.cryptochecker.ui.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.robertvargic.cryptochecker.R
import com.robertvargic.cryptochecker.ui.base.BaseFragment

class PortfolioFragment : BaseFragment(), PortfolioContract.View {

    lateinit var portfolioPresenter: PortfolioContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setPresenter(PortfolioPresenter(this))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_portfolio, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initialization goes here
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
