package com.robertvargic.cryptochecker.ui.currencyList

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.robertvargic.cryptochecker.R
import com.robertvargic.cryptochecker.models.Currency
import kotlinx.android.synthetic.main.list_item_currency.view.*

class CurrencyListAdapter(private val items: MutableList<Currency>, private val context: Context) : RecyclerView.Adapter<CurrencyListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_currency, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindData(items[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(currency: Currency) {
            itemView.list_item_currency_title.text = currency.name
            itemView.list_item_currency_price.text = currency.priceUsd
        }
    }
}