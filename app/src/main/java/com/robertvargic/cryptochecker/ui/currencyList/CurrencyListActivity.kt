package com.robertvargic.cryptochekerjava

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.robertvargic.cryptochecker.R
import com.robertvargic.cryptochecker.ui.currencyList.CurrencyListContract
import com.robertvargic.cryptochecker.ui.currencyList.CurrencyListPresenter

class CurrencyListActivity : AppCompatActivity(), CurrencyListContract.View {

    private lateinit var currencyListPresenter : CurrencyListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_list)

        setPresenter(CurrencyListPresenter(this))

        currencyListPresenter.getCurrencyList(this)
    }

    override fun setPresenter(presenter: CurrencyListContract.Presenter) {
        currencyListPresenter = presenter
    }

    override fun startLoadingAnimation() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stopLoadingAnimation() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initListView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
