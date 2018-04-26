package com.robertvargic.cryptochecker.ui.currencyList

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.robertvargic.cryptochecker.R
import com.robertvargic.cryptochecker.models.Currency
import kotlinx.android.synthetic.main.activity_currency_list.*

class CurrencyListFragment : Fragment(), CurrencyListContract.View {

    //presenter
    private lateinit var currencyListPresenter: CurrencyListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setPresenter(CurrencyListPresenter(this))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_currency_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity_currency_list_list_view.layoutManager = LinearLayoutManager(context)
        currencyListPresenter.getCurrencyList(context)
    }

    override fun setPresenter(presenter: CurrencyListContract.Presenter) {
        currencyListPresenter = presenter
    }

    override fun startLoadingAnimation() {
    }

    override fun stopLoadingAnimation() {
    }

    override fun initListView(currencyList: MutableList<Currency>?) {
        val currencyListAdapter = CurrencyListAdapter(currencyList!!, context)
        activity_currency_list_list_view.adapter = currencyListAdapter
        activity_currency_list_list_view.adapter.notifyDataSetChanged()
    }
}