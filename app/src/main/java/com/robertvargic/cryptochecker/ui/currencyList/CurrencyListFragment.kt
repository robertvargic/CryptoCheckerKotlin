package com.robertvargic.cryptochecker.ui.currencyList

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.robertvargic.cryptochecker.R
import com.robertvargic.cryptochecker.models.Currency
import com.robertvargic.cryptochecker.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_currency_list.*

class CurrencyListFragment : BaseFragment(), CurrencyListContract.View {

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
        fragment_currency_list_list_view.layoutManager = LinearLayoutManager(context)
        currencyListPresenter.getCurrencyList()
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
        fragment_currency_list_list_view.adapter = currencyListAdapter
        fragment_currency_list_list_view.adapter.notifyDataSetChanged()
    }
}