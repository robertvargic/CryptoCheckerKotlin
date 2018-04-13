package com.robertvargic.cryptochecker.ui.currencyList

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.robertvargic.cryptochecker.models.Currency

class CurrencyListAdapter : BaseAdapter() {

    private lateinit var currencyList: List<Currency>

    override fun getItem(p0: Int): Any {
        return currencyList[p0]
    }

    override fun getItemId(p0: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        return currencyList.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}